package no.bibsys.overdueNotices;

//import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class AnalyticsServiceImplementationTest {

	// @Test
	public void test() {

		
//		OverdueService.Factory.instance().sendClaims("NB");
//		OverdueService.Factory.instance().sendSecondNotice("NB");
//		OverdueService.Factory.instance().sendThirdNotice("NB");

		
		
		List<String> claimsReport = OverdueService.Factory.instance().sendFirstNotice("NB", "Publikumstjenesten");
		System.out.println(claimsReport);
//		for (String string : claimsReport) {
//			System.out.println(string);
//		}
		
//		List<OverdueNotice> report = AnalyticsService.Factory.instance().getAnalyticsReport("NB");
//		
//		for (OverdueNotice overdueNotice : report) {
//			
//			System.out.println(overdueNotice.reportPresentation());
//		}
		
		
	}

}
