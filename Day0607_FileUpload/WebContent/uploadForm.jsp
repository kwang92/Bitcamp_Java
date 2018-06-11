<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- servlet3 이후에 사용가능 --%>
	<form action = "upload" method = "post" enctype="multipart/form-data">
<!-- 		<input type = "hidden" name = "command" value = "fileUpload"> -->
		file : <input type = "file" name = "uploadFile">
		<input type = "submit" value = "전송">
	</form>
</body>
</html>