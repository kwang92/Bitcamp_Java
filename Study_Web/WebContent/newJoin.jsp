<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/newJoin.css">

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
<script src="./js/newJoin.js"></script>
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
			<form action="newJoin">
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
					<tr>
						<td colspan = "2"><label class="gender_op" onmousedown="clicked(this)"><input
								type="radio" name="check_gender" value="M">남자</label> <label
							class="gender_op" onmousedown="clicked(this)"><input
								type="radio" name="check_gender" value="F">여자</label></td>
					</tr>
					<tr class = "birth">
						<td>생일</td>
						<td class = "birth">
							<input type = "text" name = "year" placeholder = "년(4자)">
							<select name = "month">
								<option value = "">월</option>
								<option value = "01">1월</option>
								<option value = "02">2월</option>
								<option value = "03">3월</option>
								<option value = "04">4월</option>
								<option value = "05">5월</option>
								<option value = "06">6월</option>
								<option value = "07">7월</option>
								<option value = "08">8월</option>
								<option value = "09">9월</option>
								<option value = "10">10월</option>
								<option value = "11">11월</option>
								<option value = "12">12월</option>
							</select>
							<input type = "text" name = "day" placeholder = "일">
						</td>
					</tr>
				</table>

				<input type="submit" value="가입완료">
			</form>
		</div>
	</div>
</body>
</html>