<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>번호</th><th class = "title">제목</th><th>작성자</th>
		</tr>
		<c:forEach items = "${viewPage.board}" var = "board">
			<tr>
				<td>${board.b_id}</td>
				<td>${board.title}</td>
				<td>%{board.writer}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>