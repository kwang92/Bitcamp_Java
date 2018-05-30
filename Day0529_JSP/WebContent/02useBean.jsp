<%@ page import = "model.Member" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member m = (Member)request.getAttribute("member");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>액션태그</title>
</head>
<body>
	Member m : <%=m%>
</body>
</html>