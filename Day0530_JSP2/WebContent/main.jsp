<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! String pwd; %>
<%
	String id = (String)request.getSession().getAttribute("id");
%>
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

<style type = "text/css">
	#wrap{
		width : 100%;
		margin-top : 200px;
	}
	#content{
		width : 500px;
		margin : 0 auto;
	}
	
</style>
</head>
<body>
	<div id = "wrap">
		<div id = "content">
			<h3><%=id %>님 반갑습니다.</h3>
			<button onclick = "location.href = 'memberlist'">회원목록</button>
			<button onclick = "location.href = 'modify'">정보수정</button>
			<button onclick = "location.href = 'logout'">로그아웃</button>
		
		</div>
	</div>
</body>
</html>