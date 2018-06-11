<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 확인</title>
<link rel ="stylesheet" type = "text/css" href = "css/board.css">
</head>
<body>
	<div class = "wrap" align = "center">
		<h1>비밀번호 확인</h1>
		<form action = "board" name = "frm" method = "post">
			<input type="hidden" name="command" value ="boardCheckPass">
			<input type="hidden" name ="num" value = "${param.num}">
			<table>
				<tr>
					<th>비밀번호</th>
					<td><input type = "password" name = "pass" size = "20"></td>
				</tr>
			</table>
			<input type = "submit" value = "확인"> 
		</form>
		${msg}
	</div>
</body>
</html>