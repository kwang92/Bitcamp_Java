<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>새 글 작성</title>
<link rel ="stylesheet" type = "text/css" href = "css/board.css">
<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script type="text/javascript" src="js/write.js"></script>
<style type = "text/css">
	#wrap{
		width : 100%;
	}
	form,h1{
		width : 760px;
		margin : 0 auto;
	}
</style>
</head>
<body>
	<div class = "wrap" align = "center">
		<h1>게시글 등록</h1>
		<form action = "board" name = "boardFrm" onSubmit = "return submitCheck()" method="POST" >
			<input type = "hidden" name = "command" value = "boardWrite">
			<table>
				<tr>
					<th>작성자</th>
					<td><input type = "text" name = "name" id = "name"><span class = "needName">*필수</span></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type = "password" name = "pass" id = "pass"><span class = "needPass">*필수(게시글 수정, 삭제시 필요합니다.)</span></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type = "text" name = "email" id = "email"><span class = "needEmail">*필수</span></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type = "text" name = "title"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea rows = "15" cols = "70" name = "content" style = "border : 1px solid black">
						</textarea>		
					</td>
				</tr>
			</table>
			<br>
			<input type = "submit" value = "등록">
			<input type = "reset" value = "다시작성">
			<input type = "button" value = "목록" onclick = "location.href='board?command=boardList'">
		</form>
	</div>
</body>
</html>