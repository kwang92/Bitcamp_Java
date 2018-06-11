<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String msg = "";
%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" type = "text/css" href = "css/login.css">
<script type = "text/javascript" src = "./js/login.js"></script>
</head>
<body>
	<%
		if(request.getSession().getAttribute("reason") != null){
			msg = (String)request.getSession().getAttribute("reason");
			%>
			<script type = "text/javascript">
				$(function(){
					$("#error").css("display","block");
				});
			</script>
		<%}%>
	
	
	<div id = "wrap">
		<div id = "content">
			<form action = "loginCheck" name = "frm1" onSubmit = "return false"
				method = "POST">
				<fieldset>
					<legend>로그인</legend>
					<p>
						<label>아이디&nbsp;&nbsp;&nbsp;<input type = "text" id = "id"
								name = "id" onkeydown="down(event)"></label>
					</p>
					<p>
						<label>비밀번호<input type = "password" id = "pwd" name = "pwd"
								onkeydown="down(event)"></label>
					</p>
					<p id = "error">
						<%=msg %>
					</p>
					<p>
						<input type = "button" value = "로그인" onclick = "frm1.submit()">
						<input type = "button" value = "회원가입" onclick = "location.href = 'MemberJoinForm'">
					</p>
				</fieldset>		
			</form>
		</div>
	</div>
</body>
</html>