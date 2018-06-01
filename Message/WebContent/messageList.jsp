<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type = "text/css">
	*{
		margin : 0;
		padding : 0;
	}

	th{
		background-color: lightgray;
	}
	th,td{
		border : 1px solid lightgray;
	}
	#wrap{
		width : 100%;
		margin-top : 50px;
	}
	#list{
		width : 780px;
		margin : 0 auto;
	}
	form{
		width : 780px;
		margin : 0 auto;
	}
	textarea {
		width : 97%;
		margin : 10px;
	}
	#input{
		width : 100%;
	}
	#end{
		border : 0;
		text-align: right;
	}
	form p{
		text-align: right;
	}
	input{
		border : 0;
	}
</style>
</head>
<body>
	<div id = "wrap">
		<table id = "list">
			<tr><th>번호</th><th>내용</th><th>글쓴이</th></tr>
			<c:forEach items = "${msgs}" var = "msg">
				<tr>
					<th>${msg.id}</th>
					<td>${msg.message}</td>
					<td>${msg.name}</td>
				</tr>
			</c:forEach>
		</table>
		
		<form action = "write" method = "POST">
			<table id = "input">
				<tr>
					<th>이름</th>
					<td><input type = "text" placeholder = "이름을 입력하세요" name = name></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type = "password" placeholder = "비밀번호를 입력하세요" name = password></td>
				</tr>
				<tr>
					<th colspan ="2">내용</th>
				</tr>
				<tr>
					<td colspan = "2" rowspan = "2">
						<textarea name = "context">		
						</textarea>
					</td>
				</tr>
			</table>
			<p><input type = "submit" value = "전송"></p>
		</form>
	</div>
</body>
</html>