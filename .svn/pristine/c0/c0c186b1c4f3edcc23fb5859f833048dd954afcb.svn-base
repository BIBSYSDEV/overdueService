package no.bibsys.overdueNotices;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import no.bibsys.overdueNotices.OverdueServiceImplementation.OverdueLog;

public class OverdueServiceImplementationTest {

//	@Test
	public void test() {
		Map<String, String> testMap = new HashMap<>();
		
		System.out.println(testMap.get(null));
	}

	
//	@Test
	public void testLog(){
		
		OverdueServiceImplementation service = new OverdueServiceImplementation();
		OverdueLog overdueLog = service.findOverdueLog("123123", "NB");
		System.out.println(overdueLog);
		service.updateOverdueLogStatus(overdueLog.getId(), "TESTET", "");
		overdueLog = service.findOverdueLog("123123", "NB");
		System.out.println(overdueLog);
		
	}
}
