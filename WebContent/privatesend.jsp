<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   	<form action="doprivatesendmessage" method="post">
   		请输入您要发送的信息:<br />
   		<textarea name="message" rows="4" cols="120"></textarea>
   		<br />
   		<input type="submit" value="发送信息" />
   		<input type="reset" value="重置" />
   		
   	</form>  

</body>
</html>