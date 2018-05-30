<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%!
	String msg = "";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/index.css">
<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script src="./js/index.js"></script>
<style type = "text/css">
	#error{
		font-size : 11px;
		color : red;
		display : none;
	}
</style>
</head>
<body>
	<%
		
		if( ( request.getAttribute("reason") ) != null){
			msg = (String)(request.getAttribute("reason")); 
			%>
			<script type = "text/javascript">	
				$(function(){
					$("#error").css("display","block");	
				});
			</script>
			<%
		}
	%>
	<div id="wrap">
		<div id="content">
			<form action="login" name="frm1"  onSubmit = "return false" method="POST">
				<%-- POST 방식으로 보내면 URL에 보내는 값들을 적지않고 보냄 --%>
				<fieldset>
					<legend>로그인</legend>
					<p>
						<label>아이디&nbsp;&nbsp;&nbsp;<input type="text" id = "id"
							name="user_id" onkeydown = "down(event)"></label>
					</p>
					<p>
						<label>비밀번호<input type="password" id = "pwd" name="user_pwd" onkeydown = "down(event)"></label>
					</p>
					<p id = "error">
						<%=msg%>
					</p>
					<p>
						<input type="button" value="로그인" onclick = "frm1.submit()">
						<input type="button" value = "회원가입" onclick = "location.href = 'newJoin.jsp'" >
					</p>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>