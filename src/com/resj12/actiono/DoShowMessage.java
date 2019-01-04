package com.resj12.actiono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.resj12.dao.MessageDAO;
import com.resj12.vo.Messages;

import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class DoShowMessage
 */
public class DoShowMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoShowMessage() {
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
		MessageDAO dao=new MessageDAO();
		List<Messages> list=new ArrayList<>();
		list=dao.findAll();
		HttpSession session=request.getSession();
		ServletContext application=session.getServletContext();
		application.setAttribute("list", list);
		response.sendRedirect("show.jsp");		
	}

}
