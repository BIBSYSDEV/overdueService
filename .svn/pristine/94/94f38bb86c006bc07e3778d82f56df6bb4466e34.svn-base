package no.bibsys.overdueNotices;

import java.util.List;

public interface AnalyticsService {

	public class Factory{
		
		private static AnalyticsService instance = new AnalyticsServiceImplementation("ada.bibsys.no");
		private static String institutionServiceHost = "ada.bibsys.no";
		
		public static AnalyticsService instance(String institutionServiceHost){

		    if(!institutionServiceHost.equals(Factory.institutionServiceHost)){
		        instance = new AnalyticsServiceImplementation(institutionServiceHost);
		        Factory.institutionServiceHost = institutionServiceHost;
		    }
		    
			return instance;
		}
		
		public static void setInstance(AnalyticsService newInstance){
			
			instance = newInstance;
		}
		
		public static void resetInstance(String institusionServiceHost){
			instance = new AnalyticsServiceImplementation(institusionServiceHost);
		}
	}

	List<OverdueNotice> getAnalyticsReport(String library);
	OverdueNotice getOverdueNotice(String barcode, String libraryCode);
}
