package no.bibsys.overdueNotices;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public interface OverdueNotice extends Comparable<OverdueNotice>{

	public enum OverdueStatus {
		NOT_OVERDUE("", ""),
		FIRST_NOTICE("Automatisk purring", "1. gangs purring"),
		SECOND_NOTICE("Purring 1", "2. gangs purring"),
		THIRD_NOTICE("Purring 2", "3. gangs purring"),
		CLAIMS("Erstatningskrav", "Erstatningskrav"),
		ERROR("ERROR", "ERROR");

		private String text = "";
        private String fulfillmentText;

		private OverdueStatus(String text, String fulfillmentText){
			this.text = text;
            this.fulfillmentText = fulfillmentText;
		}

		public static OverdueStatus findStatusByText(String text){
			text = (text == null)?"":text;
			for (OverdueStatus status: values()) {
				if(text.equalsIgnoreCase(status.text)||text.equalsIgnoreCase(status.name()))
					return status;
			}

			return OverdueStatus.NOT_OVERDUE;
		}

		public String generateFulfilmentNote(String date){
			return fulfillmentText + " " + date;
		}
	}

	public class Factory{

		private static Map<String, OverdueNotice> overdueNoticeBuffer = new HashMap<>();
		private static Properties emailProperties;
		
		public static Properties emailTextProperties(){
			
			emailProperties = new Properties();

			try(InputStream inputStream = new FileInputStream("/fasehome/applikasjoner/overdue/emailtexts.properties")){

			    Reader reader = new InputStreamReader(inputStream, "UTF-8");
//				Reader reader = new InputStreamReader(inputStream);
				emailProperties.load(reader);
			}catch(IOException ioe){
			}
			
			return emailProperties;
		}
		
		public static OverdueNotice create(String barcode, String dueDateString, String sentDateString, String lendingDateString, String lendingLibraryEmail,
				String title, String author, String year, String publisherPlace, String publisher, String library,
				String requestId, String location, String locationCode, String libraryID) {

			OverdueNotice overdueNotice = new OverdueNoticeImplementation( barcode,  dueDateString, sentDateString, lendingDateString,  lendingLibraryEmail,
					title,  author,  year,  publisherPlace,  publisher,  library,
					requestId,  location,  locationCode,  libraryID);

			overdueNoticeBuffer.put(barcode, overdueNotice);
			
			return overdueNotice;
		}


		public static OverdueNotice retrieveOverdueNotice(String barcode){
			
			return overdueNoticeBuffer.get(barcode);
			
		}
	}

	public boolean firstNoticeSent();
	public boolean secondNoticeSent();
	public boolean thirdNoticeSent();
	public boolean claimsSent();

	public OverdueStatus status();
	public String reportPresentation();
	public String location();

	public String createFirstNotice();
	public String createSecondNotice();
	public String createThirdNotice();
	public String createClaims();

	public String barcode();
	String setOverdueStatus(OverdueStatus status, boolean sent);
	public boolean itemInPlace();
	public String lendingLibraryEmail();
	String addInformationToText(String text, Location lendingLocation);
	public String lendingLibraryCode();
	public void updateLendingLibraryEmail(String email);



}
