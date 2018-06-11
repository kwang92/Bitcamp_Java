<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	    <% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<link rel="stylesheet" type="text/css" href= "<%=path %>/css/newJoin.css?ver=3">
<script src="<%=path%>/js/newJoin.js?ver=4"></script>
<style type = "text/css">
	#error{
		display : none;
		font-size : 11px;
		color : red;
	}	
</style>

</head>
<body>
	<%
		
		if( request.getAttribute("join_res") != null ){
			if(request.getAttribute("join_res").equals("SUC")){
			%>
			<script type = "text/javascript">
				alert("가입성공");
			</script>
			
			<%
			}else{
				%>
				<script type = "text/javascript">
				alert("가입실패");
				</script>
				<%
			}
		}
	%>
	<div id="wrap">
		<div id="join">
			<img src = "./img/logo.PNG" id = "logo">
			<form action="newJoin" method = "POST" onSubmit = "return submitCheck()">
				<table>
					<tr class = "input_info">
						<td colspan="2"><input type="text" name="id" id = "id"
							placeholder="아이디를 입력하세요"><span class = "needId"></span></td>
					</tr>
					<tr class = "input_info">
						<td colspan="2"><input type="password" name="pwd" id ="pw1" 
							placeholder="비밀번호를 입력하세요"><span class = "needPw1"></span></td>
					</tr>
					<tr class = "input_info">
						<td colspan="2"><input type="password" name="pwd2" id = "pw2" 
							placeholder="비밀번호 재확인"><span class = "needPw2"></span>
									
						</td>
						
					</tr>
					<tr class = "input_info">
						<td colspan="2"><input type="text" name="name" placeholder="이름을 입력하세요"></td>
					</tr>
					<tr>
						<td colspan = "2"><label class="gender_op" onmousedown="clicked(this)"><input
								type="radio" name="check_gender" value="M">남자</label> <label
							class="gender_op" onmousedown="clicked(this)"><input
								type="radio" name="check_gender" value="F">여자</label></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td class = "email">
							<input type = "text" name = "mail" placeholder = "이메일 주소를 입력하세요">							
							<select name = "site">
								<option value = "">직접입력</option>
								<option value = "@naver.com">@naver.com</option>
								<option value = "@gmail.com">@gmail.com</option>
								<option value = "@daum.net">@daum.net</option>
							</select>
						</td>
					</tr>
				</table>
				<button onclick = "history.back(-1)">뒤로가기</button>
				<input type="submit" value="가입완료">
			</form>
		</div>
	</div>
</body>
</html>