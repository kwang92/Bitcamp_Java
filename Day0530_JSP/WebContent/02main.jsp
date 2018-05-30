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
		String id = "UnKnown";
		for(Cookie c : request.getCookies()){
			if(c.getName().equals("user_id")){
				id = c.getValue();
			}
		}
	%>
	현재 접속중인 아이디  쿠키 : <%= id %>
	<button onclick = "location.href='logout'">로그아웃</button>
</body>
</html>