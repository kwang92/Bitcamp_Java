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
#content{
	width : 480px;
	margin : 0 auto;
	border : 1px solid lightgray;
}
form{
	text-align: center;
}
</style>
</head>
<body>
	<div id="wrap">
		<div id="content">
			<form action="loginCheck.jsp" name="frm1" method="POST">
				<%-- POST 방식으로 보내면 URL에 보내는 값들을 적지않고 보냄 --%>
				<fieldset>
					<legend>로그인</legend>
					<p>
						<label>아이디&nbsp;&nbsp;&nbsp;<input type="text"
							name="user_id"></label>
					</p>
					<p>
						<label>비밀번호<input type="password" name="user_pwd"></label>
					</p>
					<p>
						<input type="submit" value="로그인">
						<input type="button" value = "회원가입" onclick = "location.href = 'newJoin.jsp'" >
					</p>
				</fieldset>
			</form>
			
		</div>
	</div>
</body>
</html>