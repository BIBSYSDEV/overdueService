package no.bibsys.overdueNotices;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import no.bibsys.overdueNotices.OverdueServiceImplementation.OverdueLog;

public class OverdueServiceImplementationTest {

	@Test
	public void testSendMail() {
		OverdueService overdueServiceImplementation = new OverdueServiceImplementation();
		overdueServiceImplementation.allItems("g").forEach(item -> System.out.println(item));;
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
