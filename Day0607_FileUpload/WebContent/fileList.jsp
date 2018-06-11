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
	<button onclick = "location.href = 'file?command=fileList'">리스트 요청</button><hr>
	<c:forEach items = "${fileList}" var = "file">
		<a href = "file?command=download&filename=${file}">${file}</a><br>
	</c:forEach>
</body>
</html>