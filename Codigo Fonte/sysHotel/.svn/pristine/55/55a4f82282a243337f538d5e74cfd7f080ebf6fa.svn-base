package org.sysHotel.filter;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
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

import org.sysHotel.entity.LoginUser;

@WebFilter("/*")
public class IdentityFilter implements Filter, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2499883384721401548L;

	
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
	      try {
	    	  
	            // check whether session variable is set
	            HttpServletRequest req = (HttpServletRequest) request;
	            HttpServletResponse res = (HttpServletResponse) response;
	            HttpSession ses = req.getSession(false);
	            String reqURI = req.getRequestURI();
	            if ( reqURI.indexOf("/login.xhtml") >= 0 ||reqURI.contains("/img/") ||(ses != null && ses.getAttribute("usuarioLogado") != null)
	                                       || reqURI.indexOf("/public/") >= 0 || reqURI.contains("javax.faces.resource") )
	            	filterChain.doFilter(request, response);
	            else{
	                   res.sendRedirect(req.getContextPath() + "/login.xhtml"); 
	            }
	      }
	     catch(Throwable t) {
	         System.out.println( t.getMessage());
	     }
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
