<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>두번 째 페이지 입니다.</h1>
	pageContext 속성 : <%= pageContext.getAttribute("name") %><br>
	request 속성 : <%= request.getAttribute("name") %><br>
	session 속성 : <%= session.getAttribute("name") %><br>
	application 속성 : <%= application.getAttribute("name") %>
</body>
</html>

