package com.wc.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySqlDBConnector {

	// getting connection with database
	public static EntityManager dbConnection() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("whichcontact-pu");
		EntityManager em = emf.createEntityManager();
		return em;
	}

}