package com.wsm.filter;

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

import com.sun.javafx.css.CssError.StylesheetParsingError;

/**
 * Servlet Filter implementation class LanJie
 */
public class LanJie implements Filter {

    /**
     * Default constructor. 
     */
    public LanJie() {
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
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		
		String url=request.getRequestURI();
		String url2=url.substring(url.lastIndexOf("/")+1);
		String str[]= {"css","js","png","gif","jpg"};
		
		if("login.html".equals(url2) ||"dologin".equals(url2)||"register.html".equals(url2)||"doregister".equals(url2)) {
			chain.doFilter(request, response);
		}else {
			if(session.getAttribute("user")!=null) { 
				chain.doFilter(request, response);				
			}else {
				String url1=url.substring(url.lastIndexOf(".")+1);
				int num=str.length;
				for(int i=0;i<num;i++) {
					if(url1.equals(str[i])) {
						chain.doFilter(request, response);
						return ;
					}else if(i==num){
						response.sendRedirect("login.html");
						return ;
					}
				}
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
