package no.bibsys.overdueNotices;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateOverdueNoticesJob implements Job {

	private Logger log = LoggerFactory.getLogger(CreateOverdueNoticesJob.class);
	private static boolean running = false;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		try{
			if(!running){
				running = true;
				Properties libraryProperties = new Properties();
				try {
					libraryProperties.load(new FileReader("/fasehome/applikasjoner/overdue/libraries.properties"));
				} catch (IOException e) {
					log.error("Unable to load library properties");
					running = false;
					return;
				}


				String[] libraries = libraryProperties.getProperty("libraries").split(",");
				for (String library : libraries) {

					String[] locations = libraryProperties.getProperty(library).split(",");
					for (String location : locations) {

						log.debug("Sending notices for " + library + " - " + location);

						OverdueService.Factory.instance().sendFirstNotice(library, location);
						OverdueService.Factory.instance().sendSecondNotice(library, location);
						OverdueService.Factory.instance().sendThirdNotice(library, location);
					}
				}

				running = false;
			}
		}catch(Exception e){
			running = false;
			throw e;
		}
	}

}
