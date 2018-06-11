<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
<link rel ="stylesheet" type = "text/css" href = "css/board.css">

<style type = "text/css">
	table{
		border : 1px solid black;
	}
	th{
		border : 1px solid black;
	}
	tr{
		border-bottom : 1px solid black;
	}
	#write a{
		border : 1px solid black;
		padding : 5px;
	}
	td,th{
		text-align : center;
		padding : 10px;
	}
	a{
		text-decoration: none;
		color : black;
		font-weight : bold;
	}
</style>
</head>
<body>
	<div class = "wrap" align = "center">
		<table class = "list">
			<tr>
				<td id = "write">
					<a href= "board?command=boardWriteForm">게시글 등록</a>
				</td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			
			<c:forEach items = "${boardList}" var = "board">
			<tr>
				<td>${board.num}</td>
				<td><a href = "board?command=boardView&num=${board.num}">${board.title}</a></td>
				<td>${board.name}</td>
				<td>${board.writeDate}</td>
				<td>${board.readCount}</td>
			</tr>
			</c:forEach>
		</table>
	
	</div>
	
</body>
</html>