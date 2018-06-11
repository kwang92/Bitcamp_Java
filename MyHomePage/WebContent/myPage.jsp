<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script type = "text/javascript">
	$(function(){
		if("${user}"){
			$("#logInOut",parent.document).text("로그아웃");
		}else{
			$("#logInOut",parent.document).text("로그인");
		}
	});
	function readFile(){
		
	};
	function submitCheck(){
		var file = $("#fileLoad")[0].files[0];
		var reader = new FileReader();
		alert(reader.readAsText(file));
		return true;
	};
</script>
</head>
<body>
	<div id = "wrap" align = "center">
		<form action = "modify_fin" enctype="multipart/form-data" onSubmit = "return submitCheck()">
			<table>
				<tr>
					<td colspan = "2">
						<img id = "profile_Img">
					</td>
				</tr>
				<tr>
					<td colspan = "2" style = "text-align : right">
						<input type = "file" id = "fileLoad" name = "picture" value = "사진가져오기">
					</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>${user.mem_id}</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type = "password" name = "pass" value = "${user.password}"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type = "text" name = "name" value = "${user.name}"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type = "text" name = "email" value = "${user.email}"></td>
				</tr>
				<tr>
					<th>등록 게시물</th>
					<td>${user.totalWrite}</td>
				</tr>
				<tr>
					<td colspan = "2">
						<button>뒤로가기</button>
						<input type = "submit" value = "수정">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>