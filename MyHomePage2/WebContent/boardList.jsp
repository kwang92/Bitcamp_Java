<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String path = request.getContextPath(); %>
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
		createTable();
		if("${user}"){
			$("#logInOut",parent.document).text("로그아웃");
		}else{
			$("#logInOut",parent.document).text("로그인");
		}
	});
	function searchFunc(){
		var option = $("#option").val();
		var info = $("#info").val();
		var table = $("#boardList");
		$.ajax({
			url : "board?cmd=optionList",
			type : "POST",
			dataType : "json",
			data : {"option" : option, "info" : info},
			success : function(data){
				clearList();
				for(var brd in data){
					var tr = $("<tr>");
					$("<td>").text("1").appendTo(tr);
					var aTag = $("<a>").attr("href","mainForm");
					
					$("<td class = 'title'>").text(data[brd].title).css("color","black").css("text-decoration","none").appendTo(aTag);
					
					aTag.appendTo(tr);
					$("<td>").text(data[brd].writer).appendTo(tr);
					$("<td>").text(data[brd].viewCount).appendTo(tr);
					tr.appendTo(table);
				}
			}
		});
	};
	function createTable(){
		var table = $("#boardList");
		$.ajax({
			url : "board?cmd=reqList",
			type : "POST",
			dataType : "json",
			success : function(data){
				for(var brd in data){
					var tr = $("<tr>");
					$("<td>").text("1").appendTo(tr);
				
					var aTag = $("<a>").attr("href","boardView?option="+data[brd].b_id+"&cnt="+data[brd].viewCount);
					$("<td class = 'title'>").text(data[brd].title).css("color","black").css("text-decoration","none").appendTo(aTag);
					aTag.appendTo(tr);
					$("<td>").text(data[brd].writer).appendTo(tr);
					$("<td>").text(data[brd].viewCount).appendTo(tr);
					tr.appendTo(table);
				}
			},
			error : function(){
				alert("fail");
			}
		});
	};
	function clearList(){
		$("#boardList tr:gt(0)").remove();
	};
	function test(){
		$("#logInOut",parent.document).text("text");
	}
</script>
<link rel="stylesheet" type="text/css" href= "<%=path %>/css/boardList.css?ver=6">
</head>
<body>
	<div id = "listWrap" align = "center">
		<h2>자유게시판</h2>
		<table id = "boardList">
			<tr>
				<th class = "num">번호</th><th>제목</th><th class = "write">작성자</th><th class = "cnt">조회수</th>
			</tr>
		</table>
		<br>
		<div id = "search" align = "center">
			<select name = "option" id = "option">
				<option value = "title">제목</option>
				<option value = "writer">작성자</option>
			</select>
			<input type = "text" name = "info" id = "info">
			<button onclick = "searchFunc();">검색</button>
		</div>
		<br>
		<div id="navi" align = "center">
			<c:if test="${viewData.startPage !=1 }">
				<a href="messageList?page=1">[처음]</a>
				<a href="messageList?page=${viewData.startPage-1}">[이전]</a>
			</c:if>
			<c:forEach var="pageNum" begin="${viewData.startPage}"
				end="${viewData.endPage < viewData.pageTotalCount ? viewData.endPage : viewData.pageTotalCount}">
				<c:choose>
					<c:when test="${pageNum == viewData.currentPage}">
						<b>[${pageNum}]</b>
					</c:when>
					<c:otherwise>
						<a href="messageList?page=${pageNum}">[${pageNum}]</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${viewData.endPage < viewData.pageTotalCount}">
				<a href="messageList?page=${viewData.endPage+1}">[다음]</a>
				<a href="messageList?page=${viewData.pageTotalCount}">[마지막]</a>
			</c:if>
		</div>
		<div id = "foot">
			<button id = "test" onclick = "test()">테스트</button>
			<button onclick = "location.href = 'writePage'">글 쓰기</button>
		</div>
	</div>
</body>
</html>