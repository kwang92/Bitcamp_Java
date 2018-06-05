<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type = "text/javascript">

	function docload(){
		$("#d1").load("document.txt");
	};
</script>
</head>
<body>
	<%-- 비동기 방식을 이용해서 document.txt에 있는 내용을
		가져와서 d1요소에 출력
	 --%>
	<div id = "d1">
		
	</div>
	<button onclick = "docload()">데이터 로드</button>
</body>
</html>