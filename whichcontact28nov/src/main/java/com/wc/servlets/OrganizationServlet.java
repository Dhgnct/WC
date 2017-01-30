package com.wc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.istack.logging.Logger;

import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.App;
import com.wc.database.MySqlDBConnector;
import com.wc.organization.OrganizationDetails;

@WebServlet("/OrganizationServlet")
public class OrganizationServlet extends HttpServlet {
	static EntityManager em = MySqlDBConnector.dbConnection();
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(App.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			// Connection to database
			EntityManager em = MySqlDBConnector.dbConnection();

			// getting organization data from database
			@SuppressWarnings("unchecked")
			List<OrganizationDetails> items = (List<OrganizationDetails>) em
					.createNativeQuery("SELECT * FROM organization", OrganizationDetails.class).getResultList();
			Gson gson = new Gson();
			String json = gson.toJson(items);
			out.print(json);
			logger.info(json);
		} catch (Exception e) {
			logger.info("exception is" + e);

		}

	}

}
