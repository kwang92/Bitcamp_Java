<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>	<%-- fmt 태그 사용 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>		<%-- c태그 사용 --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		fmt :	데이터의 출력 형식 지정
		날짜, 숫자
		<fmt:formatNumber>	- 숫자 포멧 지정
		<fmt:formatDate>	- 날짜 포멧 지정
	 --%>
	 <c:set var = "price" value = "10000000"/>
	 <c:set var = "today" value = "<%=new Date()%>"/>
	 
	<%-- 숫자 포멧 --%>
	 숫자 : <fmt:formatNumber type = "number" value = "${price}"/><br>
	 퍼센트 : <fmt:formatNumber type = "percent" value= "${price}"/><br>
	 통화 : <fmt:formatNumber type = "currency" value= "${price}"/><br>
	 패턴 : <fmt:formatNumber pattern = "00,000,000,00" value= "${price}"/><br>
	 
	 <hr>
	<%-- 날짜 포멧 --%>
	date :<fmt:formatDate type = "date" value="${today}"/><br>
	time :<fmt:formatDate type = "time" value="${today}"/><br>
	both :<fmt:formatDate type = "both" value="${today}"/><br>
	full :<fmt:formatDate type = "date" dateStyle = "full" value="${today}"/><br>
	short :<fmt:formatDate type = "date" dateStyle = "short" value="${today}"/><br>
	pattern : <fmt:formatDate type = "date" value="${today}" pattern = "YYYY-MM-dd HH:mm:ss"/><br>
</body>
</html>