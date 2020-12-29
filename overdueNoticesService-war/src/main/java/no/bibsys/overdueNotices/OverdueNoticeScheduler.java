package no.bibsys.overdueNotices;

import static org.quartz.JobBuilder.newJob;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.WeeklyCalendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OverdueNoticeScheduler {

	private static final transient Logger log = LoggerFactory.getLogger(OverdueNoticeScheduler.class);

	private static final String OVERDUE_NOTICE_CALENDAR = "OverdueNoticeCalendar";
	private static final String SCHEDULER_JOB_GROUP = "OVERDUE_JobGroup";
	private static final String SCHEDULER_TRIGGER_GROUP = "OVERDUE_JobGroup";
	public  static final String JOB_CATEGORY_KEY = "jobCategory";
	public  static final String JOB_SCHEDULE_KEY = "jobSchedule";
	public static final String JOB_USERNAME_KEY = "userName";

	private Scheduler scheduler;
	private Properties overdueProperties = new Properties();
	private WeeklyCalendar weeklyCalendar;

	private String cronSchedule;

	public OverdueNoticeScheduler(){
		SchedulerFactory schedFact = new StdSchedulerFactory(); 
		try {
			scheduler = schedFact.getScheduler();
			weeklyCalendar = new WeeklyCalendar(); 
			weeklyCalendar.setDayExcluded(java.util.Calendar.SATURDAY, true);
			weeklyCalendar.setDayExcluded(java.util.Calendar.SUNDAY, true);
			scheduler.addCalendar(OVERDUE_NOTICE_CALENDAR, weeklyCalendar, true, true);

			try {
				overdueProperties.load(new FileReader("/fasehome/applikasjoner/overdue/overdue.properties"));
				cronSchedule = overdueProperties.getProperty("cron_schedule");
			} catch (IOException e) {
			}
			
			initalizeScheduledJobs();
			
		} catch (SchedulerException e) {
			log.error("Error adding JobExecutionFilter",e);
		}
	}

	public void startScheduler(){
		try {
			scheduler.start();
		} catch (SchedulerException e) {
			log.error("Scheduler failed to start");
		}
	}
	
	public void stopScheduler(){
		try {
			scheduler.shutdown(false);
		} catch (SchedulerException e) {
			log.error("Scheduler failed to stop");
		}
	}
	
	private void initalizeScheduledJobs() {

		String id = "CREATE_OVERDUE_NOTICES";
		if (cronSchedule != null && !cronSchedule.isEmpty()) {
			JobDetail createOverdueNoticesJob = newJob(CreateOverdueNoticesJob.class)
					.usingJobData(JOB_USERNAME_KEY, "OVERDUE")
					.withIdentity(id, SCHEDULER_JOB_GROUP)
					.build();
			log.debug("CreateOptimisedOrderListsJob:{}",cronSchedule);
			try {
				scheduleJob(createOverdueNoticesJob, cronSchedule);
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		} else {
			log.debug("No scheduling found for {}", id);
		}

	}

	private JobKey scheduleJob(JobDetail job, String schedulePattern) throws SchedulerException{
		CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule(schedulePattern);  

		Date now = new Date();
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity(job.getKey().getName(), SCHEDULER_TRIGGER_GROUP)
				.withSchedule(cronSchedule)
				.startAt(now)
				.build();
		try {
			Date date = scheduler.scheduleJob(job, trigger);
			log.debug("Scheduled to run @{}", date);
		} catch (SchedulerException e) {
			log.error("",e);
			throw e;
		}		

		return job.getKey();
	}
}
