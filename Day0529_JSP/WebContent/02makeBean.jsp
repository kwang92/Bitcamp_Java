<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Member" %>

	<jsp:useBean id = "member" class = "model.Member" scope = "request"></jsp:useBean>
	<jsp:setProperty name = "member" property = "address" value = "강남구"/>
	<jsp:forward page="02useBean.jsp"/>
    <%--
    	<jsp:useBean>
    	: javaBean 규약에 맞춰서 클래스로 생성한 객체
    	id = "" bean 인스턴스 이름   [ex) Student s1 = new Student()에서 s1의 값을 지정해주는 역할]
    	class = bean 객체의 참조 클래스
    	scope = bean의 라이프 사이클 관리 (default = page , request , session , application)
    	
    	 <jsp:setProperty> : bean의 속성을 설정하는 액션태그
    	 	name = 속성지정하고자 하는 bean의 식별자(id)
    	 	property = 설정하고자하는 bean의 속성이름
    	 	value = 설정하고자하는 속성 값
    	 	 
    	 <jsp:getProperty> : bean의 속성을 가져오는 태그
     --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>