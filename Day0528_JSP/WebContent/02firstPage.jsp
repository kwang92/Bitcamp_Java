<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 페이지간 데이터를 주고 받거나 공유하기 위해서는 기본객체의 속성을 이용 
		1. 기본객체의 속성(Attribute)이용 방법 및 데이터 공유하기
		2. 기본객체의 생명주기
		pageContext : 페이지 마다 하나씩 생성
		request : 요청마다 하나씩 생성
		session : 브라우저마다 생성
		application : 웹어플리케이션 마다 생성
		
		* 기본객체의 속성에 데이터 넣기
		기본객체.setAttribute("속성이름",데이터);
		* 기본객체 속성 가져오기
		기본객체.getAttribute("속성이름");
		"WebContent/02secondPage.jsp"
		*객체의 생명주기 확인하는 방법 
		 : 속성 집어넣어 놓고, 속성 꺼내와서 있으면 아까 그 객체, 없으면 새 객체
	--%>
	<%
		pageContext.setAttribute("name","첫 번째 페이지 page객체");
		request.setAttribute("name","첫 번째 페이지 request객체");
		session.setAttribute("name","첫 번째 페이지 session객체");
		application.setAttribute("name", "첫 번째 페이지 application객체");
	%>
	pageContext 속성 : <%= pageContext.getAttribute("name") %><br>
	request 속성 : <%= request.getAttribute("name") %><br>
	session 속성 : <%= session.getAttribute("name") %><br>
	application 속성 : <%= application.getAttribute("name") %>
	
	<%--forward로 페이지 이동 --%>
	<%
		RequestDispatcher dispacther;
		dispacther = request.getRequestDispatcher("02secondPage.jsp");
		dispacther.forward(request, response);
	%>
</body>
</html>