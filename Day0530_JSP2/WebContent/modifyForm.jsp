<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! String pw; %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>

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
	.end{
		text-align: right;
	}
</style>
<body>
		<form action = "modifyCom" name = "modi"   onSubmit = "return false"  method = "POST">
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
				<tr class = "end">
					<th colspan = "2">
						<button id = "submit" onclick = "modi.submit()">수정완료</button>
						<button id = "out" onclick = "location.href = 'outjoin'">회원탈퇴</button>
					</th>
				</tr>
			</table>
		</form>	

</body>
</html>