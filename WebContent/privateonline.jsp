<%@page import="com.resj12.vo.Users"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<meta http-equiv="refresh" content="1">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
</head>
<body><center><a href="main.html" target="_top">点击进入群聊</a></center>
	<%
		List<Users> online=(List<Users>)application.getAttribute("online");	
		Users user=(Users)session.getAttribute("user");
		if(online==null){
			out.println("当前没有人在线");
		}else{
			int size=online.size();
	%>
		<center>当前在线人数：<%=size %></center></br>
		<%
			for(int i=0;i<size;i++){
				Users u=online.get(i);
				int id1=user.getUserid();
				int id2=u.getUserid();
				if(id1==id2){
		%>
			<%=user.getUsername() %><br />
		<%			
				}else{
		%>
			<a href="preprivatemain?userid=<%=id2%>" target="_top"><%=u.getUsername() %></a><br />
	<%			}
			}
		}
	%>
</body>
</html>