<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>요청 객체 리뷰</title>
</head>
<body>
	<%-- 
		1. 클라이언트가 요청 		2. 서버가 요청정보 확인, 응답
		JSP 내에서 요청정보를 확인 할 수 있는 내장 객체 : request
		<request>
		 : 웹 브라우저의 요청정보를 제공하는 객체, 클라이언트 및 서버의 정보를 가지고 있음
		 : request객체에는 클라이언트가 보내는 정보도 포함되어있다.
	--%>
	클라이언트 IP = <%= request.getRemoteAddr() %><br>		 <%-- 클라이언트의 IP를 받아오는 메소드 --%>
	요청의 길이 = <%= request.getContentLength() %><br> 	 <%-- 받은 요청의 길이를 가져오는 메소드 --%>
	요청 URI = <%= request.getRequestURI() %>	   <br>		 <%-- 요청 URI 가져오는 메소드 --%>
	Context Path = <%= request.getContextPath() %>  	 <%-- 컨텍스트 경로를 받아오는 메소드 --%>
</body>
</html>