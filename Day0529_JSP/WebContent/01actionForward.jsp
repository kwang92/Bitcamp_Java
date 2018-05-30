<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	<%
		String color = request.getParameter("color");
		String url = "";
		switch(color){
		case "red":
			url = "01red.jsp";
			break;
		case "blue":
			url = "01blue.jsp";
			break;
		case "yellow":
			url = "01yellow.jsp";
			break;
		}
	%>
	<jsp:forward page= "<%=url%>">
		<jsp:param value = "홍길동" name = "name"/>
	</jsp:forward> <%-- forward 기능을 동작하는 액션태그 --%>
</body>
</html>