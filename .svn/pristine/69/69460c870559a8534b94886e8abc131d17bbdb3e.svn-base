package no.bibsys.overdueNotices;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import no.bibsys.alma.rest.AlmaItemRecord;
import no.bibsys.overdueNotices.OverdueServiceImplementation.OverdueLog;

public interface OverdueService {

	public class Factory{
		
		private static OverdueService instance = new OverdueServiceImplementation();
		
		public static OverdueService instance(){
			
			return instance;
		}
		
		public static void setInstance(OverdueService newInstance){
			instance = newInstance;
		}
	}
	
	public List<String> sendClaims(String library, String location);
	List<String> sendClaims(String library, String locationName, String email);
	public List<String> sendFirstNotice(String library, String location);
	public List<String> sendFirstNotice(String library, String location, String email);
	public List<String> sendSecondNotice(String library, String location);
	public List<String> sendSecondNotice(String library, String location, String email);
	public List<String> sendThirdNotice(String library, String location);
	public List<String> sendThirdNotice(String library, String location, String email);
	public List<String> createClaimsReport(String library);
//	public Library retrievePartner(String libraryCode, String partnerCode);
	public List<Location> retrieveLocations(String libraryCode);
	public AlmaItemRecord retrieveItem(String barcode, String library);
//	public AlmaItemRecord updateItemRecord(AlmaItemRecord itemRecord, String library);
	public List<String> allItems(String library);
	Map<String, Location> allPartners(String library);
	String csvReport(String library, String location);
	public String resetNotes(String library, String location);
	String emailTexts();
	OverdueLog findOverdueLog(String barcode, String institution);
	int addOverdueLog(String barcode, String status, String institution);
	void updateOverdueLogStatus(int id, String status, String message);
    String findLocationEmail(String library, String lendingLibraryCode);
    String pdfTexts();
    public Path createPdf(String library, String lendingLocation, String barcode);
	

}
