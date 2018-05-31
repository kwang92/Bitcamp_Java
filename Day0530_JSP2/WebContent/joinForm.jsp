<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/join.css">

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>

<style type = "text/css">
	#error{
		display : none;
		font-size : 11px;
		color : red;
	}	
</style>
<script src="<%=path %>/js/join.js"></script>
</head>
<body>

	<div id="wrap">
		<div id="join">
			<img src = "<%=path %>/img/logo.PNG" id = "logo">
			<form action="addUser" method = "POST">
				<table>
					<tr class = "input_info">
						<td colspan="2"><input type="text" name="id"
							placeholder="아이디를 입력하세요"></td>
					</tr>
					<tr class = "input_info">
						<td colspan="2"><input type="password" name="pwd" id ="pw1" 
							placeholder="비밀번호를 입력하세요"></td>
					</tr>
					<tr class = "input_info">
						<td colspan="2"><input type="password" name="pwd2" id = "pw2" 
							placeholder="비밀번호 재확인">
							<p id = "error" >비밀번호가 서로 다릅니다.</p>
						</td>
						
					</tr>
					<tr class = "input_info">
						<td colspan="2"><input type="text" name="name" placeholder="이름을 입력하세요"></td>
					</tr>
					<tr class = "input_info">
						<td><input type = "text" name = "email" placeholder="이메일 주소를 입력하세요"></td>
						<td class = "mail">
							<select name = "mail">
								<option value = "n">직접입력</option>
								<option value = "@daum.net">@daum.net</option>
								<option value = "@gmail.com">@gmail.com</option>
								<option value = "@naver.com">@naver.com</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan = "2"><label class="gender_op" onmousedown="clicked(this)"><input
								type="radio" name="check_gender" value="M">남자</label> <label
							class="gender_op" onmousedown="clicked(this)"><input
								type="radio" name="check_gender" value="F">여자</label></td>
					</tr>
				</table>

				<input type="submit" value="가입완료">
			</form>
		</div>
	</div>
</body>
</html>