package com.wc.batch;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.App;
import com.wc.database.MySqlDBConnector;
import com.wc.organization.OrganizationDataService;
import com.wc.rest.crunchbase.api.CrunchbaseApi;
import com.wc.rest.crunchbase.response.CruchbaseResponse;
import com.wc.rest.crunchbase.response.Organization;

public class SchedulerJob implements Job {
	final static Logger logger = Logger.getLogger(App.class);
	final static EntityManager em = MySqlDBConnector.dbConnection();

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		CruchbaseResponse companies = CrunchbaseApi.getAllOrganizations();
		List<Organization> items = companies.getData().getItems();
		int totalOrganizations = items.size();
		for (int orgCount = 0; orgCount < totalOrganizations; orgCount++) {
			OrganizationDataService.add(items.get(orgCount).getUuid(), items.get(orgCount).getProperties().getName(),
					items.get(orgCount).getProperties().getDomain(),
					items.get(orgCount).getProperties().getHomepage_url(),
					items.get(orgCount).getProperties().getCountry_code());
		}
		logger.info("database filled");
	}

}
