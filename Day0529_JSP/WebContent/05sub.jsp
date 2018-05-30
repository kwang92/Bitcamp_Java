<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page = "05header.jsp"/>
	<hr>
	<h2>여기는 서브 페이지 입니다.</h2>
	<a href = "05main.jsp">메인으로 이동</a>
	<hr>
	<jsp:include page = "05footer.jsp"/>
</body>
</html>