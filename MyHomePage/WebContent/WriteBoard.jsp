<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "wrap">
		<form action = "write" name = "writeBoard">
			<table>
				<tr>
					<th>제목</th><td><input type = "text" name = "title"></td>
				</tr>
				<tr class = "board">
					<td colspan = "2">
						<textarea cols = "5" rows = "5" name = "context">
						
						</textarea>
					</td>
				</tr>
				<tr>
					<td colspan = "2">
						<button onclick = "location.href='goBack'">취소</button>
						<button onclick = "writeBoard.submit()">작성</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>