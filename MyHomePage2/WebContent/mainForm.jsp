<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kwang</title>
<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<link rel="stylesheet" type="text/css" href= "<%=path %>/css/main.css?ver=8">
<script src="<%=path %>/js/main.js?ver=8"></script>
</head>
<body>
	<div id = "header_wrap">
		<header>
			<h3>Kwang</h3>
			<ul>
				<li id = "board">게시판</li>
				<li id = "myPage">마이페이지</li>
				<li id = "logInOut"><a href = "logout" style = "color : white; text-decoration : none; font-weight : bold">로그인</a></li>
			</ul>
		</header>
	</div>
	
	<div id = "aside_wrap">
		<aside>
			<ul>
				<li>영업부</li>
				<li>기획부</li>
				<li>개발부</li>
			</ul>
		</aside>
	</div>
	<div id = "content_wrap">
		<section>
			<article>
				<iframe id = "target" onload = "det()" width = "75%" height = "580px" name = "myFrame" ></iframe>
			</article>
		</section>
	</div>
</body>
</html>