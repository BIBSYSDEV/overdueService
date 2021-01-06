package no.bibsys.overdueNotices;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Stream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.glassfish.jersey.client.JerseyClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yogthos.JsonPDF;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import no.bibsys.overdueNotices.OverdueNotice.OverdueStatus;
import no.unit.alma.bibs.AlmaItemsService;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.generated.items.Item;
import no.unit.alma.generated.partners.Address;
import no.unit.alma.generated.partners.Email;
import no.unit.alma.generated.partners.Partner;
import no.unit.alma.generated.partners.Partners;
import no.unit.alma.partners.AlmaPartnersService;

public class OverdueServiceImplementation implements OverdueService {

    static class OverdueLog {
        private int id;
        private String barcode;
        private Timestamp timestamp;
        private String status;
        private String institution;
        private String message;

        OverdueLog(int id, String barcode, Timestamp timestamp, String status, String institution, String message){
            setId(id);
            setBarcode(barcode);
            setTimestamp(timestamp);
            setStatus(status);
            setInstitution(institution);
            setMessage(message);
        }

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getBarcode() {
            return barcode;
        }
        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }
        public Timestamp getTimestamp() {
            return timestamp;
        }
        public void setTimestamp(Timestamp timestamp) {
            this.timestamp = timestamp;
        }
        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }
        public String getInstitution() {
            return institution;
        }
        public void setInstitution(String institution) {
            this.institution = institution;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "OverdueLog [id=" + id + ", barcode=" + barcode + ", timestamp=" + timestamp + ", status=" + status
                    + ", institution=" + institution + "]";
        }
    }

    private static final Map<String, Map<String, Location>> locationMap = new ConcurrentHashMap<>();

	private static final String NB_BIBCODE = "g";
	private Config config = ConfigFactory.load();
    AlmaClient almaClient = new AlmaClient(JerseyClientBuilder.newClient(), config, NB_BIBCODE);

    private final Properties overdueProperties;
    boolean test = true;
    String[] emails = new String[0];
    private final Map<String, Map<String, Item>> libraryItemMap = new HashMap<>();

    private Map<String, String> logAdressMap = new HashMap<>();

    private static final transient Logger log = LoggerFactory.getLogger(OverdueServiceImplementation.class);
    private static final String pdfPath = "/fasehome/applikasjoner/overdue/pdf/";
    private static final Set<String> partnersLoading = new CopyOnWriteArraySet<>();

    private static final OverdueNoticeScheduler scheduler = new OverdueNoticeScheduler();

    private static final String mailServerHost = "mail.bibsys.no";

    private static final String mailServerPort = "25";

    private static final String connectTimeout = "30000";

    private static final String readTimeout = "30000";

    private String institutionServiceHost;

    public OverdueServiceImplementation() {

        String institutionPropertiesFile = "/fasehome/applikasjoner/almaws/institution.properties";
        String overduePropertiesFile = "/fasehome/applikasjoner/overdue/overdue.properties";
        overdueProperties = new Properties();

        try{
            overdueProperties.load(new FileReader(overduePropertiesFile));
            test = "true".equals(overdueProperties.getProperty("test_phase"));
            emails = overdueProperties.getProperty("test_email").split(",");
            Arrays.asList(overdueProperties.getProperty("logAdresses", "all:logg-purringer@bibsys.no").split(",")).stream()
            .map(address -> address.split(":"))
            .forEach(addressArr -> logAdressMap.put(addressArr[0], addressArr[1]));

            institutionServiceHost = overdueProperties.getProperty("institutionhost", "ada.bibsys.no:8082");
            // AlmaBibService.Factory.setInstitutionServiceHost(institutionServiceHost);
        } catch (IOException e) {
            log.error("Unable to load properties: " + institutionPropertiesFile);
        }
        scheduler.startScheduler();
    }

    private Map<String, List<OverdueNotice>> prepareNotices(List<OverdueNotice> analyticsReport, String library) {
        Map<String, List<OverdueNotice>> sortedLocationMap = new ConcurrentHashMap<>();
        for (OverdueNotice overdueNotice : analyticsReport) {

            List<OverdueNotice> noticeList = sortedLocationMap
                    .computeIfAbsent(overdueNotice.lendingLibraryCode(), k -> new ArrayList<>());

            noticeList.add(overdueNotice);

            overdueNotice.updateLendingLibraryEmail(findLocationEmail(library, overdueNotice.lendingLibraryCode()));
        }


        return sortedLocationMap;
    }

    @Override
    public String findLocationEmail(String library, String lendingLibraryCode) {
        if(locationMap == null||locationMap.size() == 0||locationMap.get(library) == null){
            retrievePartners(library);
        }
        Location lendingLocation = locationMap.computeIfAbsent(library, v -> new HashMap<>()).get(lendingLibraryCode);
        if(lendingLocation == null){
            return "";
        }
        return lendingLocation.getEmail();
    }

    private Location findLocation(String library, String locationName) {

        return retrieveLocations(library)
                .stream()
                .filter(tempLocation -> locationName.equals(tempLocation.getName()))
                .findFirst().orElse(new Location());
    }


    @Override
    public List<String> sendClaims(String library, String locationName) {
        return sendClaims(library, locationName, "gs@bibsys.no"); // test
    }

    @Override
    public List<String> sendClaims(String library, String locationName, String emailAdress) {
        List<OverdueNotice> analyticsReport = OverdueAnalyticsService.Factory.instance(institutionServiceHost).getAnalyticsReport(library);

        log.debug("-----------------------------");
        log.debug("email = " + emailAdress);
        log.debug("-----------------------------");

        List<String> claimsList = new ArrayList<>();
        Location location = findLocation(library, locationName);

        String reportText = createReport(library, locationName, emailAdress, analyticsReport, claimsList, location);
        sendMail("Grunnlag for erstatningskrav", emailAdress, location.getEmail(), reportText, library);

        return claimsList;
    }

    private void sendMail(String subject, String emailAdress, String from, String mailText, String customer, String... pdfs) {

        //Get the session object  
        Properties prop = System.getProperties();  
        prop.put("mail.smtp.host", mailServerHost);
        prop.put("mail.smtp.port", mailServerPort);
        prop.put("mail.smtp.connectiontimeout", connectTimeout);
        prop.put("mail.smtp.timeout", readTimeout);

        Session session = Session.getInstance(prop);  

        //compose the message  
        try{  
            MimeMessage message = new MimeMessage(session);  
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(emailAdress));

            if(customer != null&&!customer.isEmpty()){
                try {
                    message.addRecipient(Message.RecipientType.BCC,new InternetAddress(logAdressMap.get("all")));
                } catch (MessagingException e) {
                }

                String logAdress = logAdressMap.get(customer);

                if(logAdress != null){
                    try {
                        message.addRecipient(Message.RecipientType.BCC,new InternetAddress(logAdress));
                    } catch (MessagingException e) {
                        log.error("Error adding log recipient {}: {}", logAdress, e.getMessage());
                    }
                }
            }
            message.setSubject(subject);  
            message.setText(mailText, "UTF-8");  
            
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(mailText, "UTF-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            if(pdfs != null){
                Arrays.asList(pdfs).forEach(fileName -> {
                    String fileWithPath = pdfPath + fileName;
                    DataSource source = new FileDataSource(fileWithPath);
                    try {
                        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
                        attachmentBodyPart.setDataHandler(new DataHandler(source));
                        attachmentBodyPart.setFileName(fileName);
                        multipart.addBodyPart(attachmentBodyPart);
                    } catch (MessagingException e) {
                        log.error("Error creating attachment: {}", e.getMessage());
                    }
                });
            }
            message.setContent(multipart);
            message.setSentDate(new Date());

            // Send message  
            Transport.send(message);  

        }catch (MessagingException mex) {
            log.error("Error sending email: {}", mex.getMessage());
            mex.printStackTrace();
        }  
    }

    private String createReport(String library, String locationName, String email, List<OverdueNotice> analyticsReport,
            List<String> claimsList, Location location) {
        Map<String, List<OverdueNotice>> locationNoticeMap = prepareNotices(analyticsReport, library);
        Set<String> keySet = locationNoticeMap.keySet();

        Map<String, Location> lendingLocationsMap = locationMap.get(library);
        String title = OverdueText.claims_title;
        String pdfText = OverdueText.pdf_claims_text;
        String reportTopText = OverdueText.claims_report_top_text;
        String reportHeaderText = OverdueText.claims_report_header_text;
        String reportBodyText = OverdueText.claims_report_text;
        String reportText = reportTopText;
        for (String lendingLibrary : keySet) {
            List<OverdueNotice> notices = locationNoticeMap.get(lendingLibrary);

            Location lendingLocation = lendingLocationsMap.get(lendingLibrary);

            if(notices != null&&notices.size() > 0&&lendingLocation != null){

                boolean top = false;
                for (OverdueNotice overdueNotice : notices) {
                    OverdueStatus status = overdueNotice.status();
                    log.debug("presentation = " + overdueNotice.barcode());
                    OverdueStatus overdueStatus = OverdueStatus.CLAIMS;
                    if(status == overdueStatus&&!overdueNotice.claimsSent()&&locationName.equals(overdueNotice.location())){
                        if(!top){
                            reportText += notices.get(0).addInformationToText(reportHeaderText, lendingLocation);
                            top=true;
                        }
                        reportText += updateText(location, overdueNotice.addInformationToText(reportBodyText, lendingLocation));
                        reportText = reportText.replace("{Laaneavdelingkode}", location.getLocationCode());

                        String text = overdueNotice.createClaims() + "\n";
                        claimsList.add(overdueNotice.barcode());
                        text = overdueNotice.addInformationToText(text, lendingLocation);
                        text = updateText(location, text);

                        String pdfFinalText = overdueNotice.addInformationToText(pdfText, lendingLocation);
                        pdfFinalText = updateText(location, pdfFinalText);

                        String pdfFile = createPdfFile(pdfFinalText, library, pdfPath);

                        sendMail(title.replace("{Laanebibliotek}", "Nasjonalbiblioteket"), email, lendingLocation.getEmail(), text, library, pdfFile);

                        File file = new File(pdfFile);
                        file.delete();

                    }
                }
                if(top){
                    reportText += "-------------------------------------------------------------\n\n";
                }
            }
        }
        return reportText;
    }

    private String updateText(Location location, String text) {
        String todayString = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        return text.replaceAll("\\{Laaneavdeling\\}", location.getName())
                .replaceAll("\\{Laaneadresse\\}", location.getAddress())
                .replaceAll("\\{Laanepostnr\\}", location.getPostalCode())
                .replaceAll("\\{Laanested\\}", location.getCity())
                .replaceAll("\\{Laaneavdelingkode\\}", location.getLocationCode())
                .replaceAll("\\{Laaneepost\\}", location.getEmail())
                .replaceAll("\\{Telefon\\}", location.getPhone())
                .replaceAll("\\{Purredato\\}", todayString);
    }

    @Override
    public List<String> sendFirstNotice(String library, String locationName) {
        return sendFirstNotice(library, locationName, "gs@bibsys.no"); // test
    }
    @Override
    public List<String> sendFirstNotice(String library, String locationName, String email) {
        List<OverdueNotice> analyticsReport = OverdueAnalyticsService.Factory.instance(institutionServiceHost).getAnalyticsReport(library);

        List<String> firstNoticeList = new ArrayList<>();

        String logEmailText = "";
        Location location = findLocation(library, locationName);

        Map<String, List<OverdueNotice>> locationNoticeMap = prepareNotices(analyticsReport, library);
        Set<String> keySet = locationNoticeMap.keySet();

        Map<String, Location> lendingLocationsMap = locationMap.get(library);

        String headerText = OverdueText.first_notice_header_text;
        String footerText = OverdueText.first_notice_footer_text;
        String title = OverdueText.first_notice_title;

        for (String lendingLibrary : keySet) {
            List<OverdueNotice> notices = locationNoticeMap.get(lendingLibrary);

            Location lendingLocation = lendingLocationsMap.get(lendingLibrary);

            if(notices != null&&notices.size() > 0&&lendingLocation != null){

                log.debug("# of notices: " + notices.size());
                StringBuilder text = new StringBuilder(headerText + "\n");

                firstNoticeList = new ArrayList<>();
                text = text.append(createMailText(locationName, notices, firstNoticeList, lendingLocation));
                if(!firstNoticeList.isEmpty()){

                    logEmailText += "Mail sent to " + lendingLocation.getName() +" : " + lendingLocation.getEmail() + " - " + firstNoticeList.size() + " notice(s)\n";

                    String mailBodyText = text.toString() + footerText + "\n";
                    mailBodyText = notices.get(0).addInformationToText(mailBodyText, lendingLocation);
                    mailBodyText = updateText(location, mailBodyText);
                    mailBodyText = firstNoticeList.size() > 1 ? mailBodyText.replace("{antall}", firstNoticeList.size() + " ") : mailBodyText.replace("{antall}", "");
                    mailBodyText = updateText(location, mailBodyText);

                    String recipient = findRecipient(notices);

                    if(test){
                        mailBodyText += "\n(Sendes til " + recipient + ")\n";
                        recipient = email;
                    }

                    if(!"".equals(recipient)){
                        sendMail(title.replace("{Laaneavdeling}", location.getName()), recipient, location.getEmail(), mailBodyText, library);
                    }
                }
            }
        }
        String logEmailUser = overdueProperties.getProperty("log_to_email");
        String emailTitle = "First notices log";

        logEmail(logEmailText, location, logEmailUser, emailTitle, library);

        return firstNoticeList;
    }

    private StringBuilder createMailText(String locationName, List<OverdueNotice> notices, List<String> firstNoticeList, Location lendingLocation) {
        StringBuilder text = new StringBuilder();
        OverdueStatus overdueStatus = OverdueStatus.FIRST_NOTICE;
        for (OverdueNotice overdueNotice : notices) {
            OverdueStatus status = overdueNotice.status();
            if(status == overdueStatus&&!overdueNotice.firstNoticeSent()&&locationName.equals(overdueNotice.location())){
                text.append(overdueNotice.addInformationToText(overdueNotice.createFirstNotice() + "\n", lendingLocation));
                firstNoticeList.add(overdueNotice.barcode());
            }
        }
        return text;
    }

    private void logEmail(String logEmailText, Location location, String logEmailUser, String emailTitle, String library){
        if(logEmailUser != null && !logEmailUser.isEmpty()){
            log.debug("Sending log to {}", logEmailUser);

            Arrays.asList(logEmailUser.split(",")).forEach(email -> sendMail(emailTitle, email, location.getEmail(), logEmailText, library));
        }else{
            log.debug("Found no log email users");
        }
    }

    @Override
    public List<String> sendSecondNotice(String library, String locationName) {
        return sendSecondNotice(library, locationName, "gs@bibsys.no"); // test
    }
    @Override
    public List<String> sendSecondNotice(String library, String locationName, String email) {
        List<OverdueNotice> analyticsReport = OverdueAnalyticsService.Factory.instance(institutionServiceHost).getAnalyticsReport(library);

        String headerText = OverdueText.second_notice_header_text;
        String footerText = OverdueText.second_notice_footer_text;
        String title = OverdueText.second_notice_title;
        List<String> secondNoticeList = new ArrayList<>();

        Location location = findLocation(library, locationName);

        Map<String, List<OverdueNotice>> locationNoticeMap = prepareNotices(analyticsReport, library);
        Set<String> keySet = locationNoticeMap.keySet();

        Map<String, Location> lendingLocationsMap = locationMap.get(library);

        String logEmailText = "";
        for (String lendingLibrary : keySet) {
            List<OverdueNotice> notices = locationNoticeMap.get(lendingLibrary);

            Location lendingLocation = lendingLocationsMap.get(lendingLibrary);

            int count = 0;

            if(notices != null&&notices.size() > 0&&lendingLocation != null){

                log.debug("# of notices: " + notices.size());
                String text = headerText + "\n";

                boolean found = false;
                OverdueStatus overdueStatus = OverdueStatus.SECOND_NOTICE;
                for (OverdueNotice overdueNotice : notices) {
                    OverdueStatus status = overdueNotice.status();

                    if(status == overdueStatus&&!overdueNotice.secondNoticeSent()&&locationName.equals(overdueNotice.location())){
                        text += overdueNotice.addInformationToText(overdueNotice.createSecondNotice() + "\n", lendingLocation);
                        secondNoticeList.add(overdueNotice.barcode());
                        found = true;
                        count++;
                    }
                }
                if(found){
                    logEmailText  += "Mail sent to " + lendingLocation.getName() +" : " + lendingLocation.getEmail() + " - " + count + " notice(s)\n";

                    text += footerText + "\n";
                    text = notices.get(0).addInformationToText(text, lendingLocation);
                    if(count > 1){
                        text = text.replace("{antall}", count + " ");
                    }else{
                        text = text.replace("{antall}", "");
                    }
                    text = updateText(location, text);

                    String recipient = findRecipient(notices);

                    if(test){
                        text += "\n(Sendes til " + recipient + ")\n";
                        recipient = email;
                    }

                    sendMail(title.replace("{Laaneavdeling}", location.getName()), recipient, location.getEmail(), text, library);
                }
            }	
        }
        String logEmailUser = overdueProperties.getProperty("log_to_email");
        String emailTitle = "Second notices log";
        logEmail(logEmailText, location, logEmailUser, emailTitle, library);


        return secondNoticeList;
    }

    private String findRecipient(List<OverdueNotice> notices) {
        String mottaker = notices.stream()
                .filter(notice -> notice.lendingLibraryEmail() != null&&!notice.lendingLibraryEmail().isEmpty())
                .map(notice -> notice.lendingLibraryEmail()).findFirst().orElse("");
        return mottaker;
    }

    @Override
    public List<String> sendThirdNotice(String library, String locationName) {
        return sendThirdNotice(library, locationName, "gs@bibsys.no"); // test
    }
    @Override
    public List<String> sendThirdNotice(String library, String locationName, String email) {
        List<OverdueNotice> analyticsReport = OverdueAnalyticsService.Factory.instance(institutionServiceHost).getAnalyticsReport(library);

        String headerText = OverdueText.third_notice_header_text;
        String footerText = OverdueText.third_notice_footer_text;
        String pdfHeaderText = OverdueText.pdf_third_notice_header_text;
        String pdfFooterText = OverdueText.pdf_third_notice_footer_text;
        String title = OverdueText.third_notice_title;
        List<String> thirdNoticeList = new ArrayList<>();

        Location location = findLocation(library, locationName);

        Map<String, List<OverdueNotice>> locationNoticeMap = prepareNotices(analyticsReport, library);
        Set<String> keySet = locationNoticeMap.keySet();

        Map<String, Location> lendingLocationsMap = locationMap.get(library);

        String logEmailText = "";
        for (String lendingLibrary : keySet) {
            List<OverdueNotice> notices = locationNoticeMap.get(lendingLibrary);

            Location lendingLocation = lendingLocationsMap.get(lendingLibrary);

            int count = 0;

            if(notices != null&&notices.size() > 0&&lendingLocation != null){

                log.debug("# of notices: " + notices.size());
                String text = headerText + "\n";
                String pdfText = pdfHeaderText + "\n";


                boolean found = false;
                OverdueStatus overdueStatus = OverdueStatus.THIRD_NOTICE;
                for (OverdueNotice overdueNotice : notices) {
                    OverdueStatus status = overdueNotice.status();
                    if(status == overdueStatus&&!overdueNotice.thirdNoticeSent()&&locationName.equals(overdueNotice.location())){
                        text += overdueNotice.addInformationToText(overdueNotice.createThirdNotice() + "\n", lendingLocation);
                        pdfText += overdueNotice.addInformationToText(OverdueText.pdf_third_notice_text + "\n", lendingLocation);
                        thirdNoticeList.add(overdueNotice.barcode());
                        found = true;
                        count++;
                    }else{
                        log.debug("status = " + status);
                        log.debug("sent = " + overdueNotice.thirdNoticeSent());
                        log.debug("locationName = " + overdueNotice.location());
                    }
                }
                if(found){
                    logEmailText   += "Mail sent to " + lendingLocation.getName() +" : " + lendingLocation.getEmail() + " - " + count + " notice(s)\n";
                    text += footerText + "\n";
                    pdfText += pdfFooterText + "\n";
                    text = notices.get(0).addInformationToText(text, lendingLocation);
                    pdfText = notices.get(0).addInformationToText(pdfText, lendingLocation);
                    if(count > 1){
                        text = text.replace("{antall}", count + " ");
                        pdfText = pdfText.replace("{antall}", count + " ");
                    }else{
                        text = text.replace("{antall}", "");
                        pdfText = pdfText.replace("{antall}", "");
                    }
                    text = updateText(location, text);
                    pdfText = updateText(location, pdfText);

                    String recipient = location.getEmail();
                    if(test){
                        text += "\n(Sendes til " + recipient + ")\n";
                        recipient = email;
                    }


                    String pdfFile = createPdfFile(pdfText, library, pdfPath);
                    sendMail(title.replace("{Laaneavdeling}", location.getName()), recipient, location.getEmail(), text, library, pdfFile);

                    try {
                        Files.delete(Paths.get(pdfFile));
                    } catch (IOException e) {
                        log.error("Unable to delete file " + pdfFile);
                    }
                }
            }
        }
        String logEmailUser = overdueProperties.getProperty("log_to_email");
        String emailTitle = "Third notices log";

        logEmail(logEmailText, location, logEmailUser, emailTitle, library);

        return thirdNoticeList;
    }

    private String createPdfFile(String pdfText, String library, String pdfPath) {

        String fileName = library + System.currentTimeMillis() + ".pdf"; 

        log.debug("pdf-file = " + pdfPath + fileName);
        try {
            JsonPDF.writeToStream(new ByteArrayInputStream(pdfText.getBytes(Charset.forName("UTF-8"))), new FileOutputStream( pdfPath + fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.error("--------------------------------------------------------");
            log.error("PDF-file not found!!!!!");
            log.error("--------------------------------------------------------");
        } catch (Exception e){
            log.error(pdfText);
            log.error(e.getMessage());
            e.printStackTrace();
        }
        log.debug("pdf-file done");

        return fileName;
    }

    @Override
    public List<String> createClaimsReport(String library) {

        List<String> claimsReport = new ArrayList<>();
        List<OverdueNotice> analyticsReport = OverdueAnalyticsService.Factory.instance(institutionServiceHost).getAnalyticsReport(library);
        for (OverdueNotice overdueNotice : analyticsReport) {
            OverdueStatus status = overdueNotice.status();
            if(status == OverdueStatus.CLAIMS&&overdueNotice.itemInPlace()){
                claimsReport.add(checkItemStatus(overdueNotice, library));
            }
        }

        return claimsReport;
    }

    private String checkItemStatus(OverdueNotice overdueNotice, String library){

        String itemStatus = "";

        Item itemRecord = retrieveItem(overdueNotice.barcode(), library);
        String lendingLibraryCode = overdueNotice.lendingLibraryCode();
        Map<String, Location> allPartners = allPartners(library);
        Location partner = allPartners.get(lendingLibraryCode);
        log.debug(partner.toString());
        itemStatus = overdueNotice.barcode() + "|" + 
                itemRecord.getBibData().getTitle() + "|" + 
                lendingLibraryCode + "|" +
                partner.getName();

        return itemStatus;
    }

    private Map<String, Location> retrievePartners(String libraryCode) {


        boolean loading = partnersLoading.contains(libraryCode);

        int timeoutCount = 60;

        int offset = 0;
        final int limit = 100;
        int totalRecordsCount = -1;

        if(loading){
            do{
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                loading = partnersLoading.contains(libraryCode);
            }while(timeoutCount-- > 0&&loading);


            log.debug("-------------------------------------------------------");
            log.debug("done waiting!");
            log.debug("-------------------------------------------------------");
        }
        Map<String, Location> locationsList = locationMap.get(libraryCode);

        if (locationsList == null&&!loading) {
            partnersLoading.add(libraryCode);
            locationsList = new ConcurrentHashMap<>();
            AlmaPartnersService partnerService = new AlmaPartnersService(almaClient);
            do {
                Partners partnersResponse = partnerService.retrievePartners("", "", "", limit, offset);

                totalRecordsCount = partnersResponse.getTotalRecordCount();

                List<Partner> partnerList = partnersResponse.getPartner();

                for (Partner partner : partnerList) {
                    if (partner != null) {
                        String name = partner.getPartnerDetails().getName();
                        String code = partner.getPartnerDetails().getCode();
                        try{
                            Address address = partner.getContactInfo().getAddresses().getAddress().iterator().next();
                            String postalCode = address.getPostalCode();
                            String city = address.getCity();
                            String adressLine = address.getLine1();
                            List<Email> emailList = partner.getContactInfo().getEmails().getEmail();

                            Location library = new Location();
                            library.setName(name);
                            library.setPostalCode(postalCode);
                            library.setCity(city);
                            library.setCode(code);
                            library.setAddress(adressLine);
                            library.setEmail("");
                            if(emailList.size() > 0){
                                for (Email email : emailList) {
                                    if(email.getEmailAddress() != null && !"".equals(email.getEmailAddress())){
                                        library.setEmail(email.getEmailAddress().toLowerCase());
                                        break;
                                    }
                                }
                            }
                            locationsList.put(code, library);
                        }catch(Exception e){

                        }
                    }
                }
                locationMap.put(libraryCode, locationsList);
                partnersLoading.remove(libraryCode);
                offset += 100;
            } while (offset < totalRecordsCount);
            loading = false;
        }

        return locationsList;
    }

    private void retrieveAllItems(String libraryCode){
        OverdueAnalyticsService analyticsService = OverdueAnalyticsService.Factory.instance(institutionServiceHost);
        Stream<OverdueNotice> stream = analyticsService.getAnalyticsReport(libraryCode).stream();
        stream.forEach(overdueNotice -> retrieveItem(overdueNotice.barcode(), libraryCode));
    }

    @Override
    public List<Location> retrieveLocations(String libraryCode) {

        List<Location> locationList = new ArrayList<>();

        File json = new File("/fasehome/applikasjoner/overdue/avdelinger/"
                + libraryCode
                + ".json");

        ObjectMapper mapper = new ObjectMapper();

        retrievePartners(libraryCode);

        try {
            Location[] locations = mapper.readValue(json, Location[].class);
            locationList.addAll(Arrays.asList(locations));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return locationList;
    }

    @Override
    public Item retrieveItem(String barcode, String library) {
        Map<String, Item> myItemMap = this.libraryItemMap.computeIfAbsent(library, k -> new HashMap<>());

        AlmaItemsService itemService = new AlmaItemsService(almaClient);

        Item item = myItemMap.computeIfAbsent(barcode, v -> itemService.getItem(barcode));

        return item;
    }

    @Override
    public List<String> allItems(String library) {

        Map<String, Item> map = libraryItemMap.computeIfAbsent(library, m -> {
            retrieveAllItems(library);
            return libraryItemMap.get(library);
        });

        Set<String> keySet = map.keySet();
        return new ArrayList<>(keySet);
    }

    @Override
    public Map<String, Location> allPartners(String library) {

        Map<String, Location> partnersList = locationMap.get(library);
        long delay = 3000;
        int retries = 5;

        while(partnersList == null){
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException("Error reading partnerlist");
            }
            delay = delay*2;
            retries--;
            if(retries == 0){
                throw new RuntimeException("Error reading partnerlist, timeout");
            }
            partnersList = locationMap.get(library);
        }

        return partnersList;
    }

    @Override
    public String csvReport(String library, String location) {

        StringBuilder report = new StringBuilder("sep=,\n");

        List<String> items = allItems(library);
        log.debug("{}", items);
        List<OverdueNotice> sortList = new ArrayList<>();
        for (String barcode : items) {
            OverdueNotice overdueNotice = OverdueNotice.Factory.retrieveOverdueNotice(barcode);

            if(overdueNotice == null){
                log.debug("null notice for barcode : {}", barcode);
            }

            if(overdueNotice != null && location.equals(overdueNotice.location())){
                sortList.add(overdueNotice);
            }
        }

        Collections.sort(sortList);

        for (OverdueNotice overdueNotice : sortList) {
            String[] fields = overdueNotice.reportPresentation().split("\\|");
            report.append("\"")
            .append(fields[0]).append("\",\"")
            .append(fields[3]).append("\",\"")
            .append(fields[1]).append("\",\"")
            .append(fields[4]).append("\",\"")
            .append(fields[5])
            .append("\"\n");
        }

        return report.toString();
    }

    @Override
    public String resetNotes(String library, String location) {

        String result;
        if(test){
            int count = 0;
            List<String> items = allItems(library);
            for (String barcode : items) {
                OverdueNotice overdueNotice = OverdueNotice.Factory.retrieveOverdueNotice(barcode);
                if(overdueNotice != null && overdueNotice.location().equals(location)){
                    overdueNotice.setOverdueStatus(OverdueStatus.NOT_OVERDUE, false);
                    count++;
                }
            }
            result = count + " items nullstilt!";
        }else{
            result = "Ikke mulig å nullstille Fulfilment Note i produksjon!";
        }

        return result;
    }

    @Override
    public String emailTexts(){

        StringBuilder emailTexts = new StringBuilder("");

        emailTexts.append("----------------------------\n");
        emailTexts.append(OverdueText.first_notice_header_text);
        emailTexts.append(OverdueText.first_notice_text);
        emailTexts.append(OverdueText.first_notice_footer_text);
        emailTexts.append("----------------------------\n");
        emailTexts.append("\n");
        emailTexts.append("----------------------------\n");
        emailTexts.append(OverdueText.second_notice_header_text);
        emailTexts.append(OverdueText.second_notice_text);
        emailTexts.append(OverdueText.second_notice_footer_text);
        emailTexts.append("----------------------------\n");
        emailTexts.append("----------------------------\n");
        emailTexts.append("\n");
        emailTexts.append(OverdueText.third_notice_header_text);
        emailTexts.append(OverdueText.third_notice_text);
        emailTexts.append("----------------------------\n");
        emailTexts.append("\n");
        emailTexts.append("----------------------------\n");
        emailTexts.append(OverdueText.claims_text);
        emailTexts.append("----------------------------\n");
        emailTexts.append("\n");
        emailTexts.append("----------------------------\n");
        emailTexts.append(OverdueText.claims_report_top_text);
        emailTexts.append(OverdueText.claims_report_header_text);
        emailTexts.append(OverdueText.claims_report_text);
        emailTexts.append("----------------------------\n");

        return emailTexts.toString();
    }
    
    @Override
    public String pdfTexts(){
        
        StringBuilder pdfTexts = new StringBuilder("");
        
        pdfTexts.append("----------------------------\n");
        pdfTexts.append(OverdueText.pdf_first_notice_header_text);
        pdfTexts.append(OverdueText.pdf_first_notice_text);
        pdfTexts.append(OverdueText.pdf_first_notice_footer_text);
        pdfTexts.append("----------------------------\n");
        pdfTexts.append("\n");
        pdfTexts.append("----------------------------\n");
        pdfTexts.append(OverdueText.pdf_second_notice_header_text);
        pdfTexts.append(OverdueText.pdf_second_notice_text);
        pdfTexts.append(OverdueText.pdf_second_notice_footer_text);
        pdfTexts.append("----------------------------\n");
        pdfTexts.append("----------------------------\n");
        pdfTexts.append("\n");
        pdfTexts.append(OverdueText.pdf_third_notice_header_text);
        pdfTexts.append(OverdueText.pdf_third_notice_text);
        pdfTexts.append(OverdueText.pdf_third_notice_footer_text);
        pdfTexts.append("----------------------------\n");
        pdfTexts.append("\n");
        pdfTexts.append("----------------------------\n");
        pdfTexts.append(OverdueText.pdf_claims_text);
        pdfTexts.append("----------------------------\n");
        
        return pdfTexts.toString();
    }


    @Override
    public OverdueLog findOverdueLog(String barcode, String institution){

        try (
                Connection connection = OverdueConnectionManagerSQL.getConnection();
                PreparedStatement overdueQuery = connection.prepareStatement("SELECT id, barcode, timestamp, status, institution, message FROM overdue_log WHERE barcode = ? AND institution = ?;")) {

            overdueQuery.setString(1, barcode);
            overdueQuery.setString(2, institution);
            ResultSet resultSet = overdueQuery.executeQuery();

            if(resultSet.next()){
                return new OverdueLog(resultSet.getInt("id"), resultSet.getString("barcode"), resultSet.getTimestamp("timestamp"), resultSet.getString("status"), resultSet.getString("institution"), resultSet.getString("message"));
            }
            return new OverdueLog(-1, barcode, new Timestamp(new Date().getTime()), "", institution, "");


        } catch (SQLException e) {
            log.error("", e);
            return new OverdueLog(-1, barcode, new Timestamp(new Date().getTime()), institution, "ERROR", e.getMessage());
        }
    }

    @Override
    public int addOverdueLog(String barcode, String status, String institution){

        int id = -1;
        try (
                Connection connection = OverdueConnectionManagerSQL.getConnection();
                PreparedStatement overdueQuery = connection.prepareStatement("INSERT INTO overdue_log (barcode, status, institution) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS)) {

            overdueQuery.setString(1, barcode);
            overdueQuery.setString(2, status);
            overdueQuery.setString(3, institution);
            overdueQuery.execute();

            ResultSet resultSet = overdueQuery.getGeneratedKeys();
            resultSet.next();
            id = resultSet.getInt(1);

        } catch (SQLException e) {
            log.error("", e);
        }

        return id;
    }

    @Override
    public void updateOverdueLogStatus(int id, String status, String message){

        try (
                Connection connection = OverdueConnectionManagerSQL.getConnection();
                PreparedStatement overdueQuery = connection.prepareStatement("UPDATE overdue_log SET status = ?, timestamp = ?, message = ? WHERE id = ?")) {

            Timestamp timestamp = new Timestamp(new Date().getTime());
            overdueQuery.setString(1, status);
            overdueQuery.setTimestamp(2, timestamp);
            overdueQuery.setString(3, message);
            overdueQuery.setInt(4, id);
            overdueQuery.executeUpdate();

        } catch (SQLException e) {
            log.error("", e);
        }
    }

    @Override
    public Path createPdf(String library, String lendingLibrary, String barcode) {
        
        String pdfHeaderText = OverdueText.pdf_third_notice_header_text;
        String pdfFooterText = OverdueText.pdf_third_notice_footer_text;
        
        List<OverdueNotice> analyticsReport = OverdueAnalyticsService.Factory.instance(institutionServiceHost).getAnalyticsReport(library);

        Map<String, Location> lendingLocationsMap = locationMap.get(library);
        
        OverdueNotice overdueNotice = null;
        for (OverdueNotice notice : analyticsReport) {
            if(notice.barcode().equals(barcode)){
                overdueNotice = notice;
            }
        }
        
        
        
        if(overdueNotice != null){
            Location lendingLocation = lendingLocationsMap.get(overdueNotice.lendingLibraryCode());
            log.debug("lendingLocation = {}", lendingLocation.getName());
            Location location = findLocation(library, overdueNotice.location());
            log.debug("location = {}", location.getName());
            String pdfText = pdfHeaderText + "\n";

            pdfText += overdueNotice.addInformationToText(OverdueText.pdf_third_notice_text + "\n", lendingLocation);
            pdfText += pdfFooterText + "\n";
            pdfText = overdueNotice.addInformationToText(pdfText, lendingLocation);
            pdfText = pdfText.replace("{antall}", "");
            pdfText = updateText(location, pdfText);

            String pdfFile = createPdfFile(pdfText, library, pdfPath);

            log.debug(pdfFile);
            log.debug(Paths.get(pdfPath, pdfFile).toString());
            
            return Paths.get(pdfPath, pdfFile);
        }else{
            return null;
        }
    }

}
