package com.wc.organization;

import java.util.Objects;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.App;
import com.wc.database.MySqlDBConnector;

public class OrganizationDataService {
	final static Logger logger = Logger.getLogger(App.class);

	// connecting to MySql db
	static EntityManager em = MySqlDBConnector.dbConnection();

	// Add
	// first validate the data(if already exists than update)
	public static void add(String uuid, String name, String domain, String homepage_url, String country_code) {

		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}
		OrganizationDetails comp = em.find(OrganizationDetails.class, uuid);
		if (Objects.isNull(comp)) {
			comp = new OrganizationDetails(uuid, name, domain, homepage_url, country_code);
			em.persist(comp);
			em.getTransaction().commit();
			logger.info("new data");
		} else {
			comp = em.find(OrganizationDetails.class, uuid);
			comp = new OrganizationDetails(uuid, name, domain, homepage_url, country_code);
			logger.info("record updated ");
		}
	}

	// Edit
	public static void edit(String uuid) {

		em.getTransaction().begin();
		OrganizationDetails comp = em.find(OrganizationDetails.class, uuid);
		em.getTransaction().commit();
		logger.info("updation successful");
		em.close();
	}

	// Delete
	public static void delete(String uuid) {

		em.getTransaction().begin();
		OrganizationDetails comp = em.find(OrganizationDetails.class, uuid);
		em.remove(comp);
		em.getTransaction().commit();
		logger.info("company deleted");
		em.close();
	}

	// retrieve
	public static void retrieve(String uuid) {

		em.getTransaction().begin();
		OrganizationDetails comp = em.find(OrganizationDetails.class, uuid);
		logger.info(comp.getId());
		logger.info(comp.getName());
		logger.info(comp.getDomain());
		logger.info(comp.getHomepageUrl());
		logger.info(comp.getCountryCode());
		// em.close();
	}

}
