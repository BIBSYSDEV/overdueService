package no.bibsys.functionaltest;

import net.sourceforge.jwebunit.junit.WebTestCase;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;

/**
 * 
 * @author 
 */

public class FunctionalTest extends WebTestCase {
    //Properties fra functional-tests pom.xml
    private static String applicationUrl = null;
    private static String userID = null; 
    

    
    
    @Override
    public void setUp() throws Exception {
        System.out.println("FunctionalTest.setUp()");
        //applicationUrl
        applicationUrl = System.getProperty("applicationUrl");
        if (applicationUrl == null || "".equals(applicationUrl)) {
            String errorMsg = "\"applicationUrl\" er ikke satt som System property";
            System.out.println(errorMsg);
            throw new Exception(errorMsg);
        }
        userID = System.getProperty("adgang_username");
        if (userID == null || "".equals(userID)) {
            String errorMsg = "\"adgang_username\" er ikke satt som System property";
            System.out.println(errorMsg);
            throw new Exception(errorMsg);
        }
        setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
        getTestContext().setBaseUrl(applicationUrl);
    }

    @Override
    public void tearDown() {
    }
    
    public void testStatusPage() throws Exception {
        System.out.println("FunctionalTest.testStatusPage()");
        
        beginAt("/status");
        System.out.println("Requesting status page");
        assertResponseCode(200);
//        assertTitleEquals("Status for applikasjon: myapp");
    }
}
