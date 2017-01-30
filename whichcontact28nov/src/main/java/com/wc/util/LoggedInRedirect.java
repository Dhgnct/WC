package com.wc.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
* Servlet Filter implementation class LoginedInRedirect
* 
 * if admin is already loggedIn then admin cannot go back to index.html, if user
* is already loggedIn then user cannot go back to informationForm.html.
* 
 */
@WebFilter({"/index.html" })
public class LoggedInRedirect implements Filter {

                /**
                * Default constructor.
                */
                public LoggedInRedirect() {
                                // TODO Auto-generated constructor stub
                }

                /**
                * @see Filter#destroy()
                */
                public void destroy() {
                                // TODO Auto-generated method stub
                }

                /**
                * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
                */
                public void doFilter(ServletRequest request, ServletResponse response,
                                                FilterChain chain) throws IOException, ServletException {
                                HttpServletRequest req = (HttpServletRequest) request;
                                HttpServletResponse res = (HttpServletResponse) response;
                                HttpSession session = req.getSession();
                                String adminSessionEmail = (String) session.getAttribute("Email");
                                //String userSessionEmail = (String) session.getAttribute("userEmail");
                                if (adminSessionEmail != null) {
                                                res.sendRedirect("./about.html");
                                } 
                                else {
                                                chain.doFilter(request, response);
                                                
                                                
                                }

                }

                /**
                * @see Filter#init(FilterConfig)
                */
                public void init(FilterConfig fConfig) throws ServletException {
                                // TODO Auto-generated method stub
                }

}
