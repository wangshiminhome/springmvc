package com.resj12.actiono;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resj12.dao.UsersDAO;
import com.resj12.date.sysdate;
import com.resj12.vo.Users;

/**
 * Servlet implementation class DoRegisterAction
 */
public class DoRegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoRegisterAction() {
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
		String username=request.getParameter("sname");
		String userpass=request.getParameter("pass");
		String pass=request.getParameter("rpass");
		//System.out.println(userid+"1"+username+"2"+userpass+"3"+pass);
		//if(userpass==pass) {
			String email=request.getParameter("email");
			String qq=request.getParameter("qq");
			String address=request.getParameter("address");
			String sex=request.getParameter("sex");
			String arr[]=request.getParameterValues("hobby");
			//System.out.println(email+"4"+qq+"5"+sex+"6");
			int len=arr.length;
			String loves="";
			for (int i=0;i<len;i++) {
				loves=loves+arr[i];
			}
			String year=request.getParameter("year");
			String month=request.getParameter("month");
			String day=request.getParameter("day");
			String datetime=year+month+day;
			//System.out.println(loves+""+datetime);
			//将数据封装之后保存到数据库
			sysdate sys=new sysdate();
			Users user=new Users(0, username, userpass, sys.dateTime1(), sex, address, qq, email, loves, datetime);
			UsersDAO dao=new UsersDAO();
			int i=dao.addUser(user);
			if(i>=0) {
				response.sendRedirect("login.html");
			}else {
				response.sendRedirect("regiseter.jsp");
			}
		//}
		
	}

}
