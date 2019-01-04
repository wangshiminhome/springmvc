<%@page import="com.resj12.date.sysdate"%>
<%@page import="com.resj12.vo.Users"%>
<%@page import="com.resj12.dao.UsersDAO"%>
<%@page import="com.resj12.vo.Messages"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
  
	<meta http-equiv="refresh" content="1">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
</head>
<body>
	<%
		List<Messages> list=(List<Messages>)application.getAttribute("list");
		if(list==null){
			out.println("当前系统没有任何消息！");
		}else{
			int size=list.size();
			for(int i=0;i<size;i++){
				Messages message=list.get(i);
				UsersDAO dao=new UsersDAO();
				Users user=dao.findByUserid(message.getUserid());
	%>			
	
				<%=user.getUsername() %>&nbsp;&nbsp;:&nbsp;&nbsp;<%=message.getMcontent() %>&nbsp;&nbsp;
				<%
					String date=message.getMdate();
					if(date.contains("-")){
						out.println(date);
					}else{
						sysdate sys=new sysdate();
						out.println(sys.dateTime3(date));
				}				
				%><br />
	
	<%		
			}			
		}
	%>
	

</body>
</html>