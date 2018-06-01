<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <c:if> 태그 --%>
<%-- 	<c:if test = "${param.color == 1}"> --%>
<!-- 		<span style = "color:red;">빨강</span> -->
<%-- 	</c:if> --%>
<%-- 	<c:if test = "${param.color == 2}"> --%>
<!-- 		<span style = "color:blue;">파랑</span> -->
<%-- 	</c:if> --%>
<%-- 	<c:if test = "${param.color == 3}"> --%>
<!-- 		<span style = "color:green;">초록</span> -->
<%-- 	</c:if> --%>

	<%-- choose, when, otherwise 는 if,else if, else 와 같다 --%>
	<c:choose>
		<c:when test = "${param.color == 1}">
		
		</c:when>
		<c:when test = "${param.color == 2}">
		
		</c:when>
		<c:when test = "${param.color == 3}">
		
		</c:when>
		<c:otherwise>
		
		</c:otherwise>
	</c:choose>
</body>
</html>