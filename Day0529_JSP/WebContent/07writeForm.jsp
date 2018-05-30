<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
table{
	width : 480px;
	margin : 0 auto;
	margin-top : 100px;
	text-align : center;
}
th,td{
	border : 1px solid lightgray;
}
input{
	border : 0;
}
#wrap{
	width : 100%;
}
textarea{
	width : 100%;
	text-align : left;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<form action="board" method = "POST">
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td colspan="2">내용</td>
				</tr>
				<tr>
					<td colspan="2"><textarea name="content" cols="40" rows="20">
					</textarea></td>
				</tr>
				<tr>
					<td colspan = "2" style = "border : 0"><input type = "submit" value = "작성완료"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>