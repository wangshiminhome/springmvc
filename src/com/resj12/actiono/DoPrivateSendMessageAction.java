package com.resj12.actiono;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.resj12.dao.PrivateMessageDAO;
import com.resj12.date.sysdate;
import com.resj12.vo.PrivateMessage;
import com.resj12.vo.Users;

/**
 * Servlet implementation class DoPrivateSendMessageAction
 */
public class DoPrivateSendMessageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoPrivateSendMessageAction() {
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
		String pmcontent=request.getParameter("message");
		String host=request.getRemoteHost();
		sysdate sys=new sysdate();
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("user");
		Users u=(Users)session.getAttribute("userid");
		PrivateMessage pm=new PrivateMessage(0, user.getUserid(), u.getUserid(), pmcontent, sys.dateTime1());
		//将需要发送的信息存入数据库
		PrivateMessageDAO dao=new PrivateMessageDAO();
		ServletContext application=session.getServletContext();
		List<PrivateMessage> list=(List<PrivateMessage>)application.getAttribute("privatemessage");
		int i=dao.addPrivateMessage(pm);
		if(i>=0) {
			//将需要发送的信息存入application中
			list.add(pm);
			application.setAttribute("privatemessage", list);
			response.sendRedirect("privatesend.jsp");
		}
	}

}
