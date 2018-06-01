<%@page import="model.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type = "text/css">
	#wrap{
		width : 100%;
		margin-top : 100px;
	}
	table{
		width : 760px;
		margin : 0 auto;
	}
	th{
		background-color: lightgray;
	}
	tr,td{
		border : 1px solid black;
		text-align: center;
	}
	.end{
		border : 0;
		text-align: right;
	}
</style>
</head>
<body>
	<div id = "wrap">
		<table>
			<tr>
				<th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>가입일</th>
			</tr>
			
			<c:forEach items = "${members}" var = "member">
				<tr>
					<td>${member.id}</td>
					<td>${member.pw}</td>
					<td>${member.name}</td>
					<td>${member.email}</td>
					<td>${member.regDate}</td>
				</tr>
			</c:forEach>

			<tr class = "end">
				<td  class = "end" colspan = "5">
					<button onclick = "location.href = 'stepback'">뒤로가기</button>
				</td>
			</tr>
		</table>
		
	</div>
</body>
</html>