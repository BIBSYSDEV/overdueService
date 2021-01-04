package no.bibsys.overdueNotices;

import java.util.List;

public interface OverdueAnalyticsService {

	public class Factory{
		
		private static OverdueAnalyticsService instance = new OverdueAnalyticsServiceImplementation("ada.bibsys.no");
		private static String institutionServiceHost = "ada.bibsys.no";
		
		public static OverdueAnalyticsService instance(String institutionServiceHost){

		    if(!institutionServiceHost.equals(Factory.institutionServiceHost)){
		        instance = new OverdueAnalyticsServiceImplementation(institutionServiceHost);
		        Factory.institutionServiceHost = institutionServiceHost;
		    }
		    
			return instance;
		}
		
		public static void setInstance(OverdueAnalyticsService newInstance){
			
			instance = newInstance;
		}
		
		public static void resetInstance(String institusionServiceHost){
			instance = new OverdueAnalyticsServiceImplementation(institusionServiceHost);
		}
	}

	List<OverdueNotice> getAnalyticsReport(String library);
	OverdueNotice getOverdueNotice(String barcode, String libraryCode);
}
