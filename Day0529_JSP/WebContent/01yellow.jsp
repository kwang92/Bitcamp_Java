<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor = "yellow">
	
	여기는 yellow.jsp<br>
	색깔 파라미터 : <%= request.getParameter("color") %><br>
	js:param : <%= request.getParameter("name") %>
	
</body>
</html>