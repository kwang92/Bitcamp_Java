<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath(); 
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
<script type = "text/javascript">
	$(function(){
		if("${user.mem_id}" == "${board.mem_id}"){
			$(".access").css("display","inline");
		}		
	});
	
	function delBoard(isTrue){
		alert(isTrue);
		if(isTrue){
			var data = "${board.b_id}";
			
			$.ajax({
				url : "board?cmd=delBoard",
				type : "POST",
				dataType : "json",
				data : {"delId" : data},
				success : function(data){
					if(data.result){
						window.location.replace("boardList.jsp");
					}
				}
			});
		}
	}
	function checkTrue(){
		var check = confirm("정말 삭제하시겠습니까?");
		return check;
	}
</script>
<link rel = "stylesheet" type = "text/css" href = "<%=path %>/css/boardTable.css">
</head>
<body>
	<div id = "wrap" align = "center" style = "width : 100%; height : 100%">
		<table border = "1" style = "width : 100%; height : 500px; text-align : center">
			<tr>
				<th class = "top">제목</th><td>${board.title}</td>
				<th class = "top">작성자</th><td>${board.writer}</td>
				<th class = "top">조회수</th><td>${board.viewCount}</td>
			</tr>
			<tr>
				<td id = "content" colspan = "6">
					<p style = "border : 1px solid lightgray; margin : 5px; padding : 10px; text-align: left">
						${board.context}
					</p>
				</td>
			</tr>
			<tr>
				<td colspan = "6" style = "height : 30px; text-align : right">
					<button class = "access">수정</button>
					<button class = "access" onclick = "delBoard(checkTrue())">삭제</button>
					<button onclick = "history.back(-1);">뒤로가기</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>