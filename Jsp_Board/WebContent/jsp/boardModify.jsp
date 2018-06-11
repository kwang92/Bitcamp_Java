<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 수정</title>
<link rel ="stylesheet" type = "text/css" href = "css/board.css">
</head>
<body>
	<div class = "wrap" align = "center">
		<form action = "board">
			<input type = "hidden" name = "command" value = "boardUpdate">
			<input type = "hidden" name = "num" value = "${board.num}">
			<table>
				<tr>
					<th>제목</th>
					<td><input type = "text" name = "title" value = "${board.title}"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type = "text" name = "name" value = "${board.name}"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type = "password" name = "pass" value = "${board.pass}"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type = "text" name = "email" value = "${board.email}"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><input type = "text" name = "content" value = "${board.content}"></td>
				</tr>
			</table>
			<input type = "submit" value = "수정완료">
			<input type = "button" value = "취소" onclick = "history.go(-1)">
		</form>
	</div>
</body>
</html>