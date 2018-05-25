<%@page import="java.util.Date"%>	<!-- jsp내에서 외부클래스 import 사용시 하는 방법 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	<!-- 디렉티브  -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>오늘의 날짜</h1>
	<%-- JSP에서의 주석처리 
		날짜 출력 예시해보기
	--%>
	<%! Date date = new Date(); %>
	<%= "오늘의 날짜는 "+date%>
	
</body>
</html>