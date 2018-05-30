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
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0){	// 쿠키를 지우는 방법
			for(int i = 0; i < cookies.length; i++){
				Cookie newCookie = new Cookie("name","");
				newCookie.setMaxAge(0);
				response.addCookie(newCookie);
			}
		}
	%>
</body>
</html>