<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- JSTL의 forEach 태그 
		: 배열, collection, Map등에 있는 값들을 순차적으로 접근해서 처리
		items : 돌릴 놈
		var : 각 회차에서 요소가 저장될 변수의 이름
		begin : 시작 index
		end : 끝 index
		step : 증감 값
	--%>
	<%
		String[] movieList = {"독전","데드풀2","데자뷰","스탠바이 웬디","어벤져스"};
		request.setAttribute("mList", movieList);
	%>
	<c:forEach items = "${mList}" var = "movie">
		${movie}<br>
	</c:forEach>
	<%-- 요런식으로 반복해서 값을 가져온다 for(String movie : movieList)와 동일 --%>
	
</body>
</html>