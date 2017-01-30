package com.wc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.App;
import com.wc.database.MySqlDBConnector;
import com.wc.login.User;
import com.wc.registration.RegisterService;

@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(App.class);

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String adminemail = request.getParameter("Amail");
		String adminpassword = request.getParameter("APwd");
		String useremail = request.getParameter("useremail");
		String userpassword = request.getParameter("userpassword");
		String username = request.getParameter("username");

		try {

			// Connection to database using instance of class MySqlDBConnector
			EntityManager em = MySqlDBConnector.dbConnection();

			// getting user details from database
			@SuppressWarnings("unchecked")
			List<User> user = (List<User>) em.createNativeQuery("SELECT * FROM user_details where user_email_id = '"
					+ adminemail + "' and password='" + adminpassword + "'", User.class).getResultList();
			Iterator<User> i = user.iterator();
			User emp = i.next();
			String status = null;

			// verifying admin details
			if (emp.getIs_admin()) {
				status = "validcredentials";
				out.print(status);
				RegisterService.set(useremail, userpassword, username, true);
			} else {
				status = "invalidcredentials";
				out.print(status);
			}

		} catch (Exception e) {
			logger.info("exception is" + e);

		}
	}

}
