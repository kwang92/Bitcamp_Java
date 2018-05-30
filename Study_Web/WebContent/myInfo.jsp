<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	User user = new User();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<%
	if(request.getSession().getAttribute("data") == null){
		response.sendRedirect("search");
	}
%>
<script type = "text/javascript">
	$(function(){
		
		<%
			if(request.getSession().getAttribute("data") != null){
				user = (User)request.getSession().getAttribute("data");
			}
		%>
	});
</script>
<style type = "text/css">
	#wrap{
		width : 100%;
	}
	table{
		width : 400px;
		margin : 0 auto;
	}
	th,td{
		border : 1px solid lightgray;
		padding : 5px;
	}
</style>
<title>내 정보</title>
</head>
<body>
	<div id = "wrap">
		<table>
			<tr>
				<th>이름</th>
				<td><%=user.getName()%></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><%=user.getUserid() %></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><%=user.getUserpwd() %></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><%=user.getGender() %></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><%=user.getBirth() %></td>
			</tr>
		</table>
	</div>
</body>
</html>