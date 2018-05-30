<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type = "text/css">
	form{
		width : 100%;
		margin-top : 100px;
	}
	table{
		width : 380px;
		margin : 0 auto;
		border : 1px solid black;
		text-align : center;
	}
	th,td{
		border : 1px solid lightgray;
		padding : 5px;
	}
	th{
		background-color: lightgray;
	}
	input{
		border : 0;
	}
</style>
<body>
		<form action = "modifyCom">
			<table>
			<%
				Member mem = (Member)request.getSession().getAttribute("member");
			%>
				<tr>
					<th colspan = "2">
						<%=mem.getName()%>님	
					</th>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type = "text" name = "pwd" value = "<%=mem.getPw()%>"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type = "text" name = "name"  value = "<%=mem.getName()%>"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type = "text" name = "mail"  value = "<%=mem.getEmail()%>"></td>
				</tr>				
				<tr>
					<th colspan = "2"><input type = "submit" value = "수정완료"></th>
				</tr>
			</table>
		</form>	

</body>
</html>