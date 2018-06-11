<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/board.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" type = "text/css" href = "css/board.css">
</head>
<body>
	<div class = "wrap" align = "center">
		<h1>게시글 상세보기</h1>
		<table>
			<tr>
				<th>작성자</th>
				<td>${board.name}</td>
				<th>이메일</th>
				<td>${board.email}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${board.writeDate}</td>
				<th>조회수</th>
				<td>${board.readCount}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan = "3">${board.title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan = "3">${board.content}</td>
			</tr>
			
		</table>
		<br><br><br>
		<input type = "button" value = "수정" onclick = "open_win('board?command=boardCheckPassForm&num=${board.num}','update')">
		<input type = "button" value = "삭제" onclick = "open_win('board?command=boardCheckPassForm&num=${board.num}','delete')">
		<input type = "button" value = "목록" onclick = "location.href = 'board?command=boardList'">
		<input type = "button" value = "새글 쓰기" onclick = "location.href = 'board?command=boardWriteForm'">
	</div>
	
</body>
</html>