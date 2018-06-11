<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="stylesheet" type="text/css" href= "<%=path %>/css/writeBoard.css?ver=3">

</head>
<body>
	<div id = "wrap">
		<form action = "write" name = "writeBoard" onSubmit="return false">
			<table>
				<tr>
					<th class = "tps" style = "width : 20%">작성자</th>
					<td class = "tps" style = "width : 80%; font-weight : bold"> ${user.name}</td>
				</tr>
				<tr>
					<th class = "tps" style = "width : 20%">제목</th>
					<td class = "tps" style = "width : 80%"><input type = "text" name = "title" style = "width : 100%"></td>
				</tr>
				<tr class = "board">
					<th>내용</th>
					<td class = "ops" style = "height : 400px">
						<textarea name = "context">

						</textarea>
					</td>
				</tr>
				<tr>
					<td colspan = "2" class = "ops" style = "text-align : right">
<%-- 					goBack('<%=request.getHeader("referer")%>'); --%>
						<button onclick = "history.go(-1);">취소</button>
						<button onclick = "writeBoard.submit()">작성</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>