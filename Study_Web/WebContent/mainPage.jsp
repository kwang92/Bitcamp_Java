<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kwang</title>
<link rel="stylesheet" type="text/css" href="./css/mainPage.css?ver=8">
<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script src="./js/mainPage.js"></script>
</head>
<body>
	<div id = "header_wrap">
		<header>
			<h3>Kwang</h3>
			<ul>
				<li id = "board">게시판</li>
				<li id = "myPage">마이페이지</li>
			</ul>
		</header>
	</div>
	<div id = "content_wrap">
		<section>
			<article>
				<iframe id = "target" width = "100%" height = "980px"></iframe>
			</article>
		</section>
	</div>
</body>
</html>