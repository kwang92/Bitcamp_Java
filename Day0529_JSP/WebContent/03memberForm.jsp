<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- useBean 파라미터 값 사용하기 --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "03memberInfo.jsp" method = "POST">
		<table>
			<tr>
				<th>아이디: </th>
				<td><input type = "text" name = "id" placeholder = "아이디를 입력하세요"></td>
			</tr>
			<tr>
				<th>비밀번호: </th>
				<td><input type = "password" name = "pwd" placeholder = "비밀번호를 입력하세요"></td>
			</tr>
			<tr>
				<th>이름: </th>
				<td><input type = "text" name = "name" placeholder = "이름을 입력하세요"></td>
			</tr>
			<tr>
				<th>이메일: </th>
				<td><input type = "text" name = "email" placeholder = "이메일 주소를 입력하세요"></td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type = "submit" value = "가입">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>