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

import com.resj12.dao.PrivateMessageDAO;
import com.resj12.dao.UsersDAO;
import com.resj12.vo.PrivateMessage;
import com.resj12.vo.Users;

/**
 * Servlet implementation class DoPrivateShowMessage
 */
public class DoPrivateShowMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoPrivateShowMessage() {
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
		//获取我的所有私聊信息，并将信息全部放入application中
		HttpSession session=request.getSession();
		ServletContext application=session.getServletContext();
		Users user=(Users)session.getAttribute("user");
		int id=user.getUserid();
		PrivateMessageDAO dao=new PrivateMessageDAO();
		List<PrivateMessage> list=dao.findById(id);
		if(list==null) {
			list=new ArrayList<>();
		}
		application.setAttribute("privatemessage", list);	
		response.sendRedirect("privateshow.jsp");
		
	}

}
