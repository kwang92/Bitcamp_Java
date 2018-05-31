<%@page import="model.Member"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <c:set> : JSP에서 사용할 변수선언 및 속성 지정(EL에서도 사용가능)	--%>
<c:set var="msg">HELLO</c:set>
<c:set var="map" value = "<%=new HashMap<String,Object>()%>" scope="request"></c:set>
<%-- 만들어진 속성에 값 넣기 --%>
<c:set target="${map}" property="name" value ="홍길동"></c:set>

<c:set var="member" value="<%=new Member() %>"/> <%-- member 변수 생성 --%>
<c:set target="${member}" property="name" value ="홍길순"></c:set>	<%-- member 변수의 name에 "홍길순"값 넣기 --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
		JSTL 사용하기
		: 외부 라이브러리, 라이브러리를 가져와야함
		: MAVEN REPOSITOY -> JSTL 검색, 다운 후
		: 프로젝트 내 WEB-INF - lib에 복사
		: 디렉티브에 태그 라이브러리를 사용하겠다고 선언, 태그에는 많은 종류들이 있지만 core 태그 사용
		<%@ taglib uri="" prefix ="" %>
		
		* 코어태그 종류
		set, remove, forEach, choose, whem, otherwise, if 등등
	 --%>
	 msg : ${msg}<br>
	 map : ${map }<br>
	 map[name] : ${map["name"] }<br>
	 member.name : ${member.name }<br>
	 map.name : ${map.name }<br>
	 
	 <c:remove var="member"/>	<%-- member 변수 삭제 --%>
	 삭제 후 : ${member.name }<br>
</body>
</html>