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

<link rel="stylesheet" type="text/css" href= "<%=path %>/css/main.css?ver=6">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans" rel="stylesheet">
<style type = "text/css">
*{
	font-family: 'Noto Sans', sans-serif;
	font-weight : bold;
}

#total_wrap{
	width:100%;
}

#total_wrap img{
	width:100%;
	opacity : 0.3;
	position: absolute;
	top:0;
	left:0;
	z-index : 0;
}
</style>
<script src="<%=path %>/js/main.js?ver=8"></script>
</head>
<body>
	<input type = "hidden" id = "loginSession" value = "${user}">
	<input type = "hidden" id = "loginNa" value = "${user.name}">
	<div id = "total_wrap" align = "center">
		<div id = "header_wrap">
			<header>
				<h3 id = "loginName"></h3>
				<ul>
					<li id = "board">게시판</li>
					<li id = "myPage">마이페이지</li>
					<li id = "logInOut"><a href = "logout" style = "color : #333; text-decoration : none;">로그인</a></li>
				</ul>
			</header>
		</div>
	
		<div id = "content_wrap">
			<section>
			<h1 id = "mainTitle"></h1>
				<article>
					<iframe id = "target" onload = "det()" width = "90%" height = "980px" name = "myFrame" ></iframe>
				</article>
			</section>
		</div>
	</div>
</body>
</html>