package com.resj12.actiono;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.resj12.dao.LoginMessageDAO;
import com.resj12.dao.UsersDAO;
import com.resj12.date.sysdate;
import com.resj12.vo.LoginMessage;
import com.resj12.vo.Users;

/**
 * Servlet implementation class DologinAction
 */
public class DologinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DologinAction() {
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
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String userpass=request.getParameter("password");
		HttpSession session=request.getSession();
		UsersDAO dao=new UsersDAO();
		Users user=dao.findByName(username, userpass);
			//判断是否存在该用户
		if(user == null) {
			response.sendRedirect("login.html");
			return ;
		}else {
			//将该用户信息放入session中
			session.setAttribute("user", user);
			ServletContext application=session.getServletContext();
			//获取在线人信息
			List<Users> line=(List<Users>)application.getAttribute("online");
			if(line==null) {
				//将自己信息放入online中 显示自己在线
				List<Users> l=new ArrayList<>();
				l.add(user);
				application.setAttribute("online", l);
			}else {
				int size=line.size();
				//判断是否已经登陆过而session还未来得及销毁的情况
				for(int i=0;i<size;i++) {
					Users u=line.get(i);
					int id1=u.getUserid();
					int id2=user.getUserid();
					if(id2==id1) {
						break;
					}else if(i==size-1) {
							line.add(user);
							application.setAttribute("online", line);
					}
				}
			}
		}
		//将登陆信息存储
		LoginMessage lm=new LoginMessage();
		sysdate sys=new sysdate();
		lm.setUserid(user.getUserid());
		lm.setLimdate(sys.dateTime1());
		String host=request.getRemoteHost();
		lm.setLoginip(host);
		LoginMessageDAO daolm=new LoginMessageDAO();
		if(daolm.add(lm)>=0) {
			response.sendRedirect("main.html");		
		}
	}
}

