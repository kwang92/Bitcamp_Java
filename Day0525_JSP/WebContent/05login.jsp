<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
fieldset {
	display: inline-block;
	margin: 5px;
}
input{
	margin-left : 10px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login Test</title>
</head>
<body>
	<%--
		GET 방식과 POST 방식의 차이 : GET 방식은 URL에 정보를 포함해서 보내지만 POST 방식은 기존의 URL만 보낸다 
	 --%>
	<form action="loginCheck.jsp" name="frm1" method ="POST">	<%-- POST 방식으로 보내면 URL에 보내는 값들을 적지않고 보냄 --%>
		<fieldset>
			<legend>로그인</legend>
			<p>
				<label>아이디&nbsp;&nbsp;&nbsp;<input type="text" name="user_id"></label>
			</p>
			<p>
				<label>비밀번호<input type="password" name="user_pwd"></label> 
			</p>
			<p>
				<input type = "submit" value = "로그인">
			</p>
		</fieldset>
	</form>
	
</body>
</html>