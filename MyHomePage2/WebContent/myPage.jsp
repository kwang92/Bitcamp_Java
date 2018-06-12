<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
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
<script type="text/javascript">
	
	alert("123123");
	$(function(){
		if("${user}"){
			$("#logInOut",parent.document).text("로그아웃");
		}else{
			$("#logInOut",parent.document).text("로그인");
		}
	
		
		$("#fileLoad").change(function(){
			var file = $("#fileLoad")[0].files[0];
			var url = window.URL.createObjectURL(file);
			$("#profile_Img").attr("src",url);
		});
		
	});

	var act = function doneFile(){
		var file = $("#fileLoad")[0].files[0];
		alert("이름"+file);
		var filePath = window.URL.createObjectURL(file);
		if(file){
			var url = "imageReq?image="+filePath;
			alert(url)
			location.href = url;	
		}
		
	};
</script>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/myPage.css">
</head>
<body>
	<div id="wrap" align="center">
		<form id="myFrm" action="board" method="POST" enctype="multipart/form-data">
			<!-- onSubmit = "return submitCheck()" -->
			<input type="hidden" name="cmd" value="modify_fin">
			<input type = "hidden" id = "yabi" value = "${user.profile}">
			<table>
				<tr>	
					<td colspan="2" class="img_td" id="pp">
						<img id="profile_Img" src = "imageReq" width="200" height="100" alt="프로필사진">
					</td>
				</tr>
				<tr>
					<td colspan="2" class="img_td" style="text-align: right">
					<input type="file" id="fileLoad" name="picture" value="사진가져오기"> 
					<button type="button" onclick = "act()">설정완료</button></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>${user.mem_id}</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" id="pass" name="pass"
						value="${user.password}"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" id="name" name="name"
						value="${user.name}"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" id="email" name="email"
						value="${user.email}"></td>
				</tr>
				<tr>
					<th>등록 게시물</th>
					<td>${user.totalWrite}</td>
				</tr>
				<tr>
					<td colspan="2" id="bottom">
						<button>뒤로가기</button> <input type="submit" value="수정">
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
	<script type = "text/javascript">
		alert(" 다 그려짐");
	</script>
</html>