package com.wc.registration;

import javax.persistence.EntityManager;

import com.sun.istack.logging.Logger;
import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.App;
import com.wc.database.MySqlDBConnector;
import com.wc.login.User;

public class RegisterService {
	final static Logger logger = Logger.getLogger(App.class);

	// connecting to MySql db
	static EntityManager em = MySqlDBConnector.dbConnection();

	// Add new user 
	public static void set(String email, String password, String name, boolean is_admin) {
		em.getTransaction().begin();
		User comp = new User(email, password, name, is_admin);
		em.persist(comp);
		em.getTransaction().commit();
		em.close();
	}

}
