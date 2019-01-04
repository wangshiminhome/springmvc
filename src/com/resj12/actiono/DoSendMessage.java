package com.resj12.actiono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.resj12.dao.MessageDAO;
import com.resj12.date.sysdate;
import com.resj12.vo.Messages;
import com.resj12.vo.Users;
import com.sun.media.sound.EmergencySoundbank;

/**
 * Servlet implementation class DoSendMessage
 */
public class DoSendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoSendMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mcontent=request.getParameter("message");
		String host=request.getRemoteHost();
		sysdate sys=new sysdate();
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("user");
		Messages me=new Messages(0, user.getUserid(), mcontent, sys.dateTime1());
		ServletContext application=session.getServletContext();
		List<Messages> list=(List<Messages>)application.getAttribute("list");
		MessageDAO dao=new MessageDAO();
		int i=dao.addMessage(me);
		if(i>=0) {
			list.add(me);
			application.setAttribute("list", list);
			response.sendRedirect("send.jsp");
		}
	}

}
