<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type = "text/css">
	body{
		height : 3000px;
	}
</style>
</head>
<body>
	<h1>표현언어 소개</h1>
	<p>표현언어(Expression Language)는 JSP에 값을 쉽게 표현하기 위한 언어</p>
	"HELLO"<br>
	<%="\"HELLO\""%><br>
	${"\"HELLO\""} <br>
	
	<h2>EL 연산자</h2>
	<%--
		+, -, *, /(div), %(mod) 의 산술연산자 사용가능
		==(eq), !=(ne), <(lt), >(gt), <=(le) , >=(ge)
		&&(and), ||(or), !(not)
		empty : 변수가 null인지 아니짖 검사하는 연산자
		
		* 3항 조건 연산자
		조건식? 값1 : 값2;
	 --%>
	 정수형 : ${10}<br> 
	 실수형 : ${10.1}<br>
	 문자열 : ${"홍길동"}<br>
	 논리형 : ${false}<br>
	 
	 <h3>산술 연산</h3>
	 \${5+2} : ${5+2}<br>
	 \${5+2} : ${5/2}<br>
	 \${5 div 2} : ${5 div 2}<br>
	 \${5 mod 2} : ${5 mod 2}<br>
	 
	 <h3>비교 연산</h3>
	 \${5 > 2} : ${5 > 2}<br>
	 \${5 gt 2} : ${5 gt 2}<br>
	 \${5 <= 2} : ${5 <= 2}<br>
	 \${5 le 2} : ${5 le 2}<br>
	 
	 <h3>논리 연산</h3>
	 \${(5>2) && (2 > 10)} : ${(5>2) && (2 > 10)}<br>
	 \${(5>2) and (2 > 10)} : ${(5>2) and (2 > 10)}<br>
	 \${(5>2) || (2 > 10)} : ${(5>2) || (2 > 10)}<br>
	 \${(5>2) or (2 > 10)} : ${(5>2) or (2 > 10)}<br>
	 \${(5>2) && (2 > 10)} : ${(5>2) && (2 > 10)}<br>
	 \${!((5>2) and (2 > 10))} : ${!((5>2) and (2 > 10))}<br>
	 
	 <h2>기본객체 사용</h2>
	 <h3>JSP 기본객체</h3>
	 <p>
	 	pageContext<br>
	 	request<br>
	 	session<br>
	 	application<br>
	 </p>
	 
	 <h3>EL 기본객체</h3>
	 <p>
	 	pageScope<br>
	 	requestScope<br>
	 	sessionScope<br>
	 	applicationScope<br>
	 	param : request의 파라미터 정보를 포함하는 객체<br>
	 </p>
	 
	 <%-- JSP 기본객체에 attribute 넣기 --%>
	 <%
//	 	pageContext.setAttribute("name", "page Name");
//		request.setAttribute("name", "request Name");
		session.setAttribute("name", "session Name");
		application.setAttribute("name", "application Name");
		
		Map<String, String> testMap = new HashMap<String, String>();
		testMap.put("k1", "v1");
		testMap.put("k2", "v2");
		testMap.put("k3", "v3");
		testMap.put("k4", "v4");
		
		request.setAttribute("myMap", testMap);
	 %>
	 
	 <h4>위 객체데이터들을 EL로 꺼내오기</h4>
	 page Name : ${pageScope.name}<br>
	 request Name : ${requestScope.name}<br>
	 session Name : ${sessionScope.name}<br>
	 application Name : ${applicationScope.name}<br>
	 
	 <%-- 'name'이라는 이름의 속성을 가져와서 화면에 출력
	 		page영역부터 시작해서 'name'이라는 속성을 검색해서 가져오는데
	 		'name'속성이 존재하지 않으면 page -> request -> session -> application 순으로 가져온다
 	  --%>
	 \${name} : ${name}<br> 
	 
	 <h3>요청 파라미터 꺼내오기</h3>
	 <% String name = request.getParameter("name"); %>
	 <%= name %>
	 
	 <%-- 위의 두줄과 아래 한 줄은 같은 기능이다. 시발 --%>
	 
	 ${param.name} <br>
	 ${myMap} <br>
	 ${myMap["k1"]} <br>
</body>
</html>