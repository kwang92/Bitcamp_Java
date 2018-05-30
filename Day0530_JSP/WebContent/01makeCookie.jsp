<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	// Cookie 클래스의 생성자는 생성 할 때 쿠키의 이름과 데이터를 넣어줘야한다.
   // 	Cookie cookie = new Cookie("data","hong");
    	Cookie cookie = new Cookie("name",URLEncoder.encode("홍길동","utf-8"));	// 쿠키 데이터의 한글깨짐을 막아준다.
    	// encode로 해서 보낸 쿠키는 대신 받을 때 decode로 받아야함
    	
    	// 쿠키를 해당 시간동안만 유지시킬 수 있음
    	cookie.setMaxAge(10);	// 이 쿠키가 10초동안만 유지됨
    	response.addCookie(cookie);	// 응답에 쿠키를 실어서 보낸다.
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키 만들기</title>
</head>
<body>
	쿠키이름 : <%= cookie.getName() %>
	쿠키 값   : <%= cookie.getValue() %>
</body>
</html>