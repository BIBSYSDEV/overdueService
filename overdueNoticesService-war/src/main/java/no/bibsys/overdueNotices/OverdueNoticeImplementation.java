package no.bibsys.overdueNotices;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import org.glassfish.jersey.client.JerseyClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import no.bibsys.overdueNotices.OverdueServiceImplementation.OverdueLog;
import no.bibsys.vault.AppRole;
import no.bibsys.vault.VaultClient;
import no.unit.alma.bibs.AlmaItemsService;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.commons.ApiAuthorizationService;
import no.unit.alma.generated.items.Item;

public class OverdueNoticeImplementation implements OverdueNotice {

	private static final String NB_BIBKODE = "g";
	private boolean isFirstNoticeSent = false;
	private boolean isSecondNoticeSent = false;
	private boolean isThirdNoticeSent = false;
	private boolean isClaimsSent = false;
	private String barcode;
	private String dueDateString;
	private String sentDateString;
	private Properties emailProperties;
	private String firstNoticeText = "";
	private String secondNoticeText = "";
	private String thirdNoticeText = "";
	private String claimsText = "";
	private String lendingLibraryEmail;
	private Properties overdueProperties;
	private String requestId;
	private String title;
	private boolean itemInPlace = false;
	private boolean sendt = false;

	private static final transient Logger log = LoggerFactory.getLogger(OverdueNoticeImplementation.class);
	private OverdueStatus status = OverdueStatus.FIRST_NOTICE;
	private String lendingDateString;
	private String author;
	private String location = "";
	private String publisher;
	private String library;
	private String lendingLibraryCode;
	private String year;
	private String publisherPlace;
	private String startDateString = "1999-12-31";

	private static final String NB_BIBCODE = "g";
	private Config config = ConfigFactory.load();
	// AlmaClient almaClient = new AlmaClient(JerseyClientBuilder.newClient(), config, NB_BIBCODE);

	public OverdueNoticeImplementation(String barcode, String dueDateString, String sentDateString,
			String lendingDateString, String lendingLibraryEmail, String title, String author, String year,
			String publisherPlace, String publisher, String library, String requestId, String location,
			String locationCode, String lendingLibraryCode) {
		this();

		this.lendingDateString = lendingDateString != null ? lendingDateString : "";
		this.barcode = barcode != null ? barcode : "";
		this.dueDateString = dueDateString != null ? dueDateString : "";
		this.sentDateString = sentDateString != null ? sentDateString : "";
		this.lendingLibraryEmail = (lendingLibraryEmail != null && !"".equals(lendingLibraryEmail))
				? lendingLibraryEmail
						: OverdueService.Factory.instance().findLocationEmail(library, lendingLibraryCode);
		this.title = title != null ? title : "";
		this.author = author != null ? author : "";
		this.year = year != null ? year : "";
		this.publisherPlace = publisherPlace != null ? publisherPlace : "";
		this.publisher = publisher != null ? publisher : "";
		this.library = library != null ? library : "";
		this.requestId = requestId != null ? requestId : "";
		this.location = location != null ? location : "";
		this.lendingLibraryCode = lendingLibraryCode != null ? lendingLibraryCode : "";

		Properties apiKeys = new Properties();
		String institutionProperties = "/fasehome/applikasjoner/almaws/institution.properties";
		String overduePropertiesFile = "/fasehome/applikasjoner/overdue/overdue.properties";
		try {
			apiKeys.load(new FileReader(new File(institutionProperties)));
		} catch (IOException e) {
			log.error("Failed to load properties: " + institutionProperties);
		}
		try {
			FileReader reader = new FileReader(new File(overduePropertiesFile));
			overdueProperties = new Properties();
			overdueProperties.load(reader);
			startDateString = overdueProperties.getProperty("startdate");
		} catch (IOException e) {
			log.error("Failed to load properties: " + institutionProperties);
		}
	}

	private OverdueNoticeImplementation() {
		emailProperties = OverdueNotice.Factory.emailTextProperties();

		firstNoticeText = emailProperties.getProperty("first_notice_text");

		secondNoticeText = emailProperties.getProperty("second_notice_text");

		thirdNoticeText = emailProperties.getProperty("third_notice_text");

		claimsText = emailProperties.getProperty("claims_text");
	}

	@Override
	public boolean firstNoticeSent() {

		return sendt;
	}

	@Override
	public boolean thirdNoticeSent() {

		return sendt;
	}

	@Override
	public boolean secondNoticeSent() {
		return sendt;
	}

	@Override
	public boolean claimsSent() {
		return sendt;
	}

	@Override
	public String createFirstNotice() {
		// Generate email to lender

		String text = firstNoticeText;

		status();
		isFirstNoticeSent = true;
		setOverdueStatus(status, isFirstNoticeSent);

		return text;
	}

	@Override
	public String createSecondNotice() {
		// Generate email to lender

		String text = secondNoticeText;

		status();
		isSecondNoticeSent = true;
		setOverdueStatus(status, isFirstNoticeSent);
		return text;
	}

	@Override
	public String createThirdNotice() {
		// Generate email to lending library. Lending library sends notice via ordinary
		// mail.

		String text = thirdNoticeText;
		status();
		isThirdNoticeSent = true;

		setOverdueStatus(status, isThirdNoticeSent);
		return text;
	}

	@Override
	public String createClaims() {
		// Generate email to lending library. Lending library sends claims via ordinary
		// mail.

		String text = claimsText;

		status();
		isClaimsSent = true;
		setOverdueStatus(status, isClaimsSent);
		return text;
	}

	@Override
	public String setOverdueStatus(OverdueStatus status, boolean sent) {

		Date today = new Date();

		String fulfilmentNote = status.generateFulfilmentNote(today.toString()) + (sent ? ";sent" : "");
		log.debug("------------ status ----------------");
		log.debug("status = " + status);
		log.debug("sent = " + sent);
		log.debug(fulfilmentNote);

		OverdueService overdueService = OverdueService.Factory.instance();
		OverdueLog overdueLog = overdueService.findOverdueLog(barcode, library);

		if (overdueLog.getId() > -1) {
			overdueService.updateOverdueLogStatus(overdueLog.getId(), status.name(),
					sent ? "Overdue notice sent" : "Overdue notice not sent");
		} else {
			overdueService.addOverdueLog(barcode, status.name(), library);
		}

		updateFulfilmentNote(barcode, status);

		return fulfilmentNote;
	}

	private void updateFulfilmentNote(String barcode, OverdueStatus status) {
		try {
            VaultClient vaultClient = VaultClient.builder()
	    		.withCredentials(AppRole.from(overdueProperties.getProperty("roleId"), overdueProperties.getProperty("secretId")))
		    	.build();
    		ApiAuthorizationService apiAuthorizationService = ApiAuthorizationService.builder()
			.vaultClient(vaultClient)
			.environment(overdueProperties.getProperty("environment"))
			.build();


			AlmaItemsService itemService = new AlmaItemsService(new AlmaClient(JerseyClientBuilder.newClient(), 
				config, apiAuthorizationService,
				NB_BIBCODE));
			Item itemRecord = itemService.getItem(barcode);

			String fulfillmentNote = itemRecord.getItemData().getFulfillmentNote();
			if(fulfillmentNote != null && !fulfillmentNote.isEmpty()){
				fulfillmentNote += "|";
			}else{
				fulfillmentNote = "";
			}

			String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			fulfillmentNote += status.generateFulfilmentNote(date);

			itemRecord.getItemData().setFulfillmentNote(fulfillmentNote);

			itemService.updateItemDescription(itemRecord);
		}catch(Exception e){
			log.error("Exception when updating Fulfilmentnote: {}", e);
		}
	}

	@Override
	public OverdueStatus status() {

		status = OverdueStatus.FIRST_NOTICE;
		Date overdueDate = new Date();
		try {
			overdueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dueDateString);
		} catch (ParseException e1) {
			log.error("Error parsing date: " + dueDateString);
		}
		Date today = new Date();
		Date startDate = new Date();
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateString);
		} catch (ParseException e) {
			startDate = overdueDate;
		}
		if(overdueDate.getTime() < startDate.getTime()){
			overdueDate = startDate;
		}

		long diff = today.getTime() - overdueDate.getTime();
		long overdueTime = diff / (24 * 60 * 60 * 1000);

		OverdueStatus sentStatus = OverdueStatus.NOT_OVERDUE;

		OverdueService service = OverdueService.Factory.instance();
		Item itemRecord = service.retrieveItem(barcode, library);

		if(itemRecord != null) {

			itemInPlace = "1".equals(itemRecord.getItemData().getBaseStatus().getValue());

			OverdueLog overdueLog = service.findOverdueLog(barcode, library);

			if(overdueLog.getId() > -1){
				sentStatus = OverdueStatus.findStatusByText(overdueLog.getStatus());
				Date sentDate = overdueLog.getTimestamp();
				sentDateString = new SimpleDateFormat("yyyy-MM-dd").format(sentDate);
				if(overdueDate.after(sentDate)){
					sentStatus = OverdueStatus.FIRST_NOTICE;
				}
			}

			if(overdueTime > 28*3){
				status = OverdueStatus.CLAIMS;
				sendt = (sentStatus == OverdueStatus.CLAIMS);
			}else if(overdueTime > 28*2){
				status = OverdueStatus.THIRD_NOTICE;
				sendt = (sentStatus == OverdueStatus.THIRD_NOTICE);
			}else if(overdueTime > 28){
				status = OverdueStatus.SECOND_NOTICE;
				sendt = (sentStatus == OverdueStatus.SECOND_NOTICE);
			}else{
				sendt = (sentStatus == OverdueStatus.FIRST_NOTICE);
			}
		}
		return status;
	}

	@Override
	public String reportPresentation(){
		status = status();

		String presentation = title + "|" + barcode + "|" + status.toString().toLowerCase() + "|" + dueDateString + "|" + lendingLibraryCode + "|" + lendingLibraryEmail + "|" + sendt + "|" + sentDateString ;

		return presentation;
	}

	@Override
	public String toString() {
		return "OverdueNoticeImplementation [isFirstNoticeSent=" + isFirstNoticeSent + ", isSecondNoticeSent="
				+ isSecondNoticeSent + ", isClaimsSent=" + isClaimsSent + ", barcode=" + barcode + ", dueDateString="
				+ dueDateString + ", lendingLibraryEmail=" + lendingLibraryEmail
				+ "]";
	}

	@Override
	public int compareTo(OverdueNotice o) {

		int compareTo = dueDateString.compareTo(((OverdueNoticeImplementation)o).dueDateString);

		return compareTo;
	}

	@Override
	public String barcode() {
		return (barcode != null?barcode:"");
	}

	@Override
	public String addInformationToText(String text, Location lendingLocation) {

		text = text.replace("{Laantakerbibliotek}", lendingLocation.getName());
		text = text.replace("{Adresse}", lendingLocation.getAddress());
		text = text.replace("{Postnr}", lendingLocation.getPostalCode());
		text = text.replace("{Poststed}", lendingLocation.getCity());
		text = text.replace("{Barcode}", barcode );
		text = text.replace("{Biblioteknr}", lendingLibraryCode );
		text = text.replace("{Utlaansdato}", dueDateString );
		text = text.replace("{Forfatter}: ", author.replaceAll("\\d{4}+\\s?-\\s?\\d{4}+", "").replaceAll("\\d{4}+\\s?-", "") + " ");
		text = text.replace("{Tittel}", title.replaceAll("\\\"", "\\\\\""));
		text = text.replace("{Sted}", publisherPlace);
		text = text.replace("{Utgiver}", publisher);
		text = text.replace("{aar}", year);
		text = text.replace("{Description}", year);
		text = text.replace("{Biblioteknr}", lendingLibraryCode);

		return text;
	}

	@Override
	public String location(){
		return location;
	}

	@Override
	public boolean itemInPlace() {
		return itemInPlace;
	}

	@Override
	public String lendingLibraryEmail() {
		return lendingLibraryEmail;
	}

	@Override
	public String lendingLibraryCode() {
		return lendingLibraryCode;
	}

	@Override
	public void updateLendingLibraryEmail(String email) {
		lendingLibraryEmail = email;
	}

}
