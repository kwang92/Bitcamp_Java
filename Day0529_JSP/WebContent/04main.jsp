<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = (String)request.getSession().getAttribute("user_id");
	%>
	현재 접속중인 아이디  세션 : <%= id %>
	<button onclick = "location.href='logout'">로그아웃</button>
</body>
</html>