<%@page import="com.resj12.vo.Users"%>
<%@page import="com.resj12.vo.PrivateMessage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<meta http-equiv="refresh" content="1">
</head>
<body><%
	Users u=(Users)session.getAttribute("userid");
	int userid=u.getUserid();
	Users user=(Users)session.getAttribute("user");
	List<PrivateMessage> list=(List<PrivateMessage>)application.getAttribute("privatemessage");
	int size=list.size();
	if(size==0){
		out.println("您没有私聊信息!");
	}else{
		for(int i=0;i<size;i++){
			PrivateMessage pm=list.get(i);
			int id1=pm.getSenderid();
			int id2=pm.getAccepterid();
			if(userid==id1 ||userid==id2){
				if(userid==id1){
		%>
		<%= u.getUsername()%>&nbsp;&nbsp;&nbsp;:&nbsp;<%=pm.getPmcontent() %>&nbsp;&nbsp;&nbsp;<%=pm.getPmdate() %>
		&nbsp;&nbsp;<a href="deleteprivatemessage?pmid=<%=pm.getMid() %> " >删除 </a>   <br/>
		<% 
				}else{
		 %>
	 	<%=user.getUsername() %>&nbsp;&nbsp;&nbsp;:&nbsp;<%=pm.getPmcontent() %>&nbsp;&nbsp;&nbsp;<%=pm.getPmdate() %>
	 	&nbsp;&nbsp;<a href="deleteprivatemessage?pmid=<%=pm.getMid() %> " >删除 </a> <br/>
	 
	 <%	
				 }
	 		}
	 	}
	}
%>

</body>
</html>