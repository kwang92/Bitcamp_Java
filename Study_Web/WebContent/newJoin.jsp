<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#wrap {
	width: 100%;
	margin-top: 100px;
}

#join {
	width: 580px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<div id="wrap">
		<div id="join">
			<form action="myDB.jsp">
				<fieldset>
					<legend>회원가입</legend>
					<table>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name" placeholder="이름을 입력하세요"></td>
						</tr>
						<tr>
							<td>아이디</td>
							<td><input type="text" name="id" placeholder="아이디를 입력하세요"></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="text" name="pwd" placeholder="비밀번호를 입력하세요"></td>
						</tr>
					</table>
				</fieldset>
				<input type="submit" value="가입완료">
			</form>
		</div>
	</div>
</body>
</html>