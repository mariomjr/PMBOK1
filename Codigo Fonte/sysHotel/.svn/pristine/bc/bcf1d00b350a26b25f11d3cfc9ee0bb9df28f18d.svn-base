package org.sysHotel.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sysHotel.entity.LoginUser;
import org.sysHotel.enums.SessionUser;

public class UserAutentication implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if (!this.authorize((HttpServletRequest) req)) {
			request.getRequestDispatcher(SessionUser.PAGE_LOGIN.getContext()).forward(req, res);
		}else{
//			res.setHeader("Cache-Control", "no-store");
//			res.setHeader("Pragma", "no-cache");
//			res.setDateHeader("Expires", 0);
			chain.doFilter(req, res);
		}
//		  try {
//	    	  
//	            // check whether session variable is set
//	            HttpServletRequest req = (HttpServletRequest) request;
//	            HttpServletResponse res = (HttpServletResponse) response;
//	            HttpSession ses = req.getSession(false);
//	            String reqURI = req.getRequestURI();
//	            if ( reqURI.indexOf("/login.xhtml") >= 0 || (ses != null && ses.getAttribute("username") != null)
//	                                       || reqURI.indexOf("/public/") >= 0 || reqURI.contains("javax.faces.resource") )
//	            	chain.doFilter(request, response);
//	            else{
//	                   res.sendRedirect(req.getContextPath() + "/login.xhtml"); 
//	            }
//	      }
//	     catch(Throwable t) {
//	         System.out.println( t.getMessage());
//	     }
	}

	private boolean authorize(HttpServletRequest req) {
		boolean retorno = false;
		HttpSession session = req.getSession(false);
		if (session != null) {
			LoginUser user = (LoginUser) session.getAttribute(SessionUser.SESSION_USER_REGISTERED.getContext());
			if ((user != null) && (user.isLogado() == true)) {
				retorno = true;
			}
		}
		return retorno;
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}

}
