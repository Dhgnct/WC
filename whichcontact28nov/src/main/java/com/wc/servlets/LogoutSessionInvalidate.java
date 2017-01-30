package com.wc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
* Servlet implementation class AdminLogout
* 
 * It is used to logout the admin, invalidates admin Session.
* 
 */
@WebServlet("/LogoutSessionInvalidate")
public class LogoutSessionInvalidate extends HttpServlet {
                private static final long serialVersionUID = 1L;
  
                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                HttpSession session = request.getSession();
                                session.invalidate();
                               
                                
                                
                }
}
