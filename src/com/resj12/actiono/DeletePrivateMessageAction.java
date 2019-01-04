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
import com.resj12.vo.PrivateMessage;

/**
 * Servlet implementation class DeletePrivateMessageAction
 */
public class DeletePrivateMessageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePrivateMessageAction() {
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
		HttpSession session=request.getSession();
		ServletContext application=session.getServletContext();
		List<PrivateMessage> list=(List<PrivateMessage>)application.getAttribute("privatemessage");
		String pmid=request.getParameter("pmid");
		int pmid1=Integer.parseInt(pmid);
		//在数据库中删除私聊信息
		PrivateMessageDAO dao=new PrivateMessageDAO();
		int i=dao.deletepm(pmid1);
		if(i>=0) {
			//在application中删除私聊信息
			if(list!=null) {
				int size=list.size();
				for(int j=0;j<size;j++) {
					PrivateMessage pm=list.get(j);
					int pmd=pm.getMid();
					if(pmd==pmid1) {
						list.remove(j);
						break;
					}
				}
				application.setAttribute("privatemessage", list);
			}
			response.sendRedirect("privateshow.jsp");
		}
	}

}
