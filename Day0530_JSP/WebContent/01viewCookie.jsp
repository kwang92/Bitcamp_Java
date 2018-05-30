<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키 보기</title>
</head>
<body>
	<%
	
		// 요청에서 쿠키를 가져온다.
		// 쿠키가 여러 개 일 수 있기 때문에 쿠키 배열로 가져와야한다.
		Cookie[] cookies = request.getCookies();
		// 반복문을 돌면서 쿠키들을 하나씩 확인한다.
		if(cookies != null && cookies.length > 0){
			for(int i = 0; i < cookies.length; i++){
				
				%>
				
				쿠키이름 : <%= cookies[i].getName() %><br>
				쿠키 값   : <%= URLDecoder.decode(cookies[i].getValue(),"utf-8") %><br>
				<hr>
				<%
			}
		} else{
			%>
			쿠키가 존재하지 않음.
			<%
		}
	%>
</body>
</html>