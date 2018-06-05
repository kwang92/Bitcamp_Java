<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script type = "text/javascript">
	// form 요소에 submit 이벤트가 발생했을 때, ajax 요청 만들기
	$(function(){
		$("#memberForm").on("submit",function(){
			var d = $(this).serialize();
			var command = "?command=hello";
			alert("d : " + d);
			$.ajax({
				url : "member"+command,
				type : "get",
				data : d,
				dataType : 'json',
				success : function(data){
					
				}
			});
			return false; // submit의 진행을 멈춤 form 자체의 action을 막아줌
		});
		
		$("#userid").blur(function(){
			var id = $("#userid").val();
			var command = "?command=idCheck";
			$.ajax({
				url : "member"+command,
				type : "post",
				data : {"id" : id},
				//dataType : 'text',
				dataType : 'json',
				success : function(data){
					//$("#idresult").text(data);
					$("#idresult").text(data.res);
				}
			});
		});

	});
</script>
<style type = "text/css">
	#idresult{
		color : red;
		font-size: 9px;
	}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "hello" method = "post" name = "memberForm" id = "memberForm">
		<fieldset>
			<legend>회원가입</legend>
			<p>아이디 : <input type = "text" name = "userid" id = "userid"> <span id = "idresult"></span></p>
			<p>이름 : <input type = "text" name = "name"></p>
			<p>이메일 : <input type = "text" name = "email"></p>
		</fieldset>
		<input type = "submit" value = "가입">
	</form>	
</body>
</html>