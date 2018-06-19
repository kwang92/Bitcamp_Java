<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
	String msg = "";
%>

<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans" rel="stylesheet">
<style type = "text/css">
*{
	font-family: 'Noto Sans', sans-serif;
}
</style>
<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script type = "text/javascript">
function checkLogin(){
	var id = $("#id").val();
	var pw = $("#pwd").val();
	$.ajax({
		url : "board?cmd=loginCheck",
		data : {"id":id, "pw":pw},
		type : "post",
		dataType : "json",
		success : function(data){
			if(data.res == "suc"){
				location.href = "board?cmd=boardList";
				return false;
			}else{
				$("#warn").text(data.res).css("color","red");
				return false;
			}
			return false;
		},
		error : function(){
			alert("실패");
		}
	});
};
</script>
<link rel="stylesheet" type="text/css" href= "<%=path %>/css/login.css?ver=3">
<script src="<%=path %>/js/login.js?ver=6"></script>
</head>
<body>

	<div id="wrap" align = "center">
	<h1>회원 로그인</h1>
		<div id="content" align = "center">
			<form action="board" name="frm1" onSubmit= "return false"
				method="POST">
				<input type = "hidden" name = "cmd" value = "loginCheck">
				<%-- POST 방식으로 보내면 URL에 보내는 값들을 적지않고 보냄 --%>
				<fieldset>
					<legend><strong>Login</strong></legend>
					<p>
						<label>아이디&nbsp;&nbsp;&nbsp;<input type="text" id="id"
							name="id" onkeydown="down(event)" autofocus></label>
					</p>
					<p>
						<label>비밀번호<input type="password" id="pwd" name="pwd"
							onkeydown="down(event)"></label>
					</p>
					<span id = "warn"></span>
					<p>
						<input type="button" value="로그인" onclick="checkLogin();">
						<input type="button" value="회원가입"
							onclick="location.href = 'board?cmd=newjoinForm'">
					</p>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>