package no.bibsys.overdueNotices;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import org.glassfish.jersey.client.JerseyClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import no.unit.alma.AlmaAnalyticsHelper;
import no.unit.alma.AlmaAnalyticsService;
import no.unit.alma.commons.AlmaClient;

public class AnalyticsServiceImplementation implements AnalyticsService {

	private static final String NB_BIBCODE = "g";
	private Config config = ConfigFactory.load();
    private AlmaAnalyticsService analyticsService = new AlmaAnalyticsService(
        new AlmaClient(JerseyClientBuilder.newClient(), config, NB_BIBCODE)
    );

	private static final transient Logger log = LoggerFactory.getLogger(AnalyticsServiceImplementation.class);

	private Properties properties;
	private String analyticsPath;
	// private ApiAuthorization apiAuthorization;

	private final Map<String,AnalyticsReport> analyticsReportMap = new HashMap<>();

	private Properties ignoredProperties;

	public AnalyticsServiceImplementation(String institutionServiceHost) {

		properties = new Properties();
		try {
			properties.load(new FileReader(new File("/fasehome/applikasjoner/overdue/overdue.properties")));
		} catch (IOException e) {
			log.error("Unable to load overdue.properties");
			throw new RuntimeException("Unable to load overdue.properties");
		}
		ignoredProperties = new Properties();
		try {
			ignoredProperties.load(new FileReader(new File("/fasehome/applikasjoner/overdue/ignored.properties")));
		} catch (IOException e) {
			log.error("Unable to load ignored.properties");
			throw new RuntimeException("Unable to load ignored.properties");
		}
		
		analyticsPath = properties.getProperty("analytics_url");
	}

	@Override
	public List<OverdueNotice> getAnalyticsReport(String library) {

		String ignoreString = ignoredProperties.getProperty(library);
		Set<String> ignoredLocations = new HashSet<>();
		if(ignoreString != null){
			ignoredLocations = new HashSet<>(Arrays.asList(ignoreString.split(",")));
		}
		AnalyticsReport analyticsReport = analyticsReportMap.get(library);
		List<OverdueNotice> result = new ArrayList<>();
		if(analyticsReport == null||analyticsReport.date.getTime() < (new Date().getTime() - 24*60*60*100)){

			List<Map<String,String>> report = new AlmaAnalyticsHelper(analyticsService).retrieveAnalyticsReport(analyticsPath, "");
			if(report != null){
				for (Map<String, String> map : report) {
					log.debug(map.toString());
					String author = map.get("Column1");
					String mmsId = map.get("Column2");
					String year = map.get("Column3");
					String publisherPlace = map.get("Column4");
					String publisher = map.get("Column5");
					String title = map.get("Column6");
					String dueDateString = map.get("Column7");
					String lendingDateString = map.get("Column8");
					String requestId = map.get("Column9");
					String barcode = map.get("Column10");
					String lendingLibraryEmail = map.get("Column11");
					String location = map.get("Column12");
					String locationCode = map.get("Column13");
					String libraryID = map.get("Column14");

					if(!ignoredLocations.contains(libraryID) && barcode != null && !"".equals(barcode.trim())){
						result.add(OverdueNotice.Factory.create(barcode, dueDateString, "", lendingDateString, lendingLibraryEmail, title, author, year, publisherPlace, publisher, library , requestId, location, locationCode, libraryID));
					}
				}

				analyticsReport = new AnalyticsReport(new Date(), result);
				analyticsReportMap.put(library, analyticsReport);
			}
		}else{
			result = new ArrayList<OverdueNotice> (analyticsReport.reportMap.values());
		}

		return result;
	}


	@Override
	public OverdueNotice getOverdueNotice(String barcode, String libraryCode) {

		AnalyticsReport analyticsReport = analyticsReportMap.get(libraryCode);
		if(analyticsReport == null||analyticsReport.date.getTime() < (new Date().getTime() - 24*60*60*100)){
			getAnalyticsReport(libraryCode);
			analyticsReport = analyticsReportMap.get(libraryCode);
		}

		return analyticsReport.reportMap.get(barcode);
	}

	private class AnalyticsReport{
		Date date;
		Map<String, OverdueNotice> reportMap = new HashMap<>();

		public AnalyticsReport(Date date, List<OverdueNotice> result) {
			this.date = date;
			for (OverdueNotice overdueNotice : result) {
				reportMap.put(overdueNotice.barcode(), overdueNotice);
			}
		}
	}
}

