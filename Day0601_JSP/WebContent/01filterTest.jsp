<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>필터 테스트 입니다.</title>
</head>
<body>
	<h1>요청받았습니다!</h1>
	id 파라미터 : <%=request.getParameter("id") %>
	name 파라미터 : <%=request.getParameter("name") %>
	pay 파라미터 : <%=request.getParameter("pay") %>
</body>
</html>