package no.bibsys.overdueNotices;

public class TestSend {

	public void testSendingMail() {
		
		OverdueService service = OverdueService.Factory.instance();
		service.sendThirdNotice("g", "Depotbiblioteket");
	}
}
