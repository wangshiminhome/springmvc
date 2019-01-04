package com.resj12.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.resj12.vo.Users;

/**
 * Application Lifecycle Listener implementation class SessionsListener
 *
 */
public class SessionsListener implements HttpSessionListener {
	public List<Users> list;

    /**
     * Default constructor. 
     */
    public SessionsListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event)  {
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event)  { 
         // TODO Auto-generated method stub
    	HttpSession session=event.getSession();
    	ServletContext application =session.getServletContext();
    	List<Users> online=(List<Users>)application.getAttribute("online");
    	Users user=(Users)session.getAttribute("user");
	    if(user!=null) {
    		int size=online.size();
	    	for (int i=0;i<size;i++) {
	    		Users u=online.get(i);
	    		int id1=u.getUserid();
				int id2=user.getUserid();
				if(id2==id1) {
	    			online.remove(i);
	    			break;
	    		}
	    	}
	    	application.setAttribute("online", online);
	    }
    }
	
}
