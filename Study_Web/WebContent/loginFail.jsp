<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type = "text/javascript">
		alert("로그인 실패");
	</script>
	<%
		String id = request.getParameter("id");
	%>
	<%=id %>님 누군지 모르겠습니다.
</body>
</html>