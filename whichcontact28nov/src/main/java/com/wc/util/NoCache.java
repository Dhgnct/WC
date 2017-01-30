package com.wc.util;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;


@WebFilter({ "*.html" })
public class NoCache implements javax.servlet.Filter {

                public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                                                throws IOException, ServletException {
                                HttpServletResponse httpResponse = (HttpServletResponse) response;
                                httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP
                                                                                                                                                                                                                                                                                                                                                                // 1.1
                                httpResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0
                                httpResponse.setDateHeader("Expires", 0); // Proxies.
                                chain.doFilter(request, response);
                }

                /**
                * @see Filter#init(FilterConfig)
                */
                public void init(FilterConfig fConfig) throws ServletException {
                                // TODO Auto-generated method stub
                }

                public void destroy() {

                }

}
