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
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.App;
import com.wc.database.MySqlDBConnector;
import com.wc.login.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(App.class);
	static EntityManager em = MySqlDBConnector.dbConnection();
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			// Connection to database
			EntityManager em = MySqlDBConnector.dbConnection();
			@SuppressWarnings("unchecked")

			// getting user details from db
			List<User> user = (List<User>) em.createNativeQuery(
					"SELECT * FROM user_details where user_email_id = '" + email + "' and password='" + password + "'",
					User.class).getResultList();
			Iterator<User> i = user.iterator();
			User emp = i.next();
			String status = null;

			// verifying admin details
			if (emp.getIs_admin()) {
				status = "validcredentials";
				HttpSession session = request.getSession();
				session.setAttribute("Email", email);
				out.print(status);
			} else {
				status = "invalidcredentials";
				out.print(status);
			}

		} catch (Exception e) {
			logger.info("exception is" + e);

		}
	}

}
