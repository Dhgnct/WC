package com.wc.servlets;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.App;
import com.wc.batch.SchedulerJob;
import com.wc.projectconfig.Config;

public class SchedulerListener implements ServletContextListener {
	Scheduler scheduler = null;
	final static Logger logger = Logger.getLogger(App.class);
	private static String JOB = null;
	private static String GROUP = null;
	private static String TRIGGER_NAME = null;
	private static String DURATION = null;

	public void contextInitialized(ServletContextEvent servletContext) {
		logger.info("Context Initialized");

		// getting required scheduler fields from project properties file
		try {
			JOB = Config.getInstance().getConfigure().getString("job-detail");
			GROUP = Config.getInstance().getConfigure().getString("group");
			TRIGGER_NAME = Config.getInstance().getConfigure().getString("trigger");
			DURATION = Config.getInstance().getConfigure().getString("cron-duration");

		} catch (ConfigurationException e1) {
			e1.printStackTrace();
		}

		try {
			// Setup the Job class and the Job group
			JobDetail job = newJob(SchedulerJob.class).withIdentity(JOB, GROUP).build();

			// Create a Trigger that fires every 1 minute.
			Trigger trigger = newTrigger().withIdentity(TRIGGER_NAME, GROUP)
					.withSchedule(CronScheduleBuilder.cronSchedule(DURATION)).build();

			// Trigger that fires every midnight at 12AM GMT
			// Trigger trigger = newTrigger().withIdentity("TriggerName",
			// "Group")
			// .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0 *
			// *?")).build();

			// Setup the Job and Trigger with Scheduler & schedule jobs
			scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent servletContext) {
		logger.info("Context Destroyed");
		try {
			scheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}