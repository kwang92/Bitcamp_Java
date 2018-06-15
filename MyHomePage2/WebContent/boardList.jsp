<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans" rel="stylesheet">
<link rel="stylesheet" type="text/css" href= "<%=path %>/css/boardList.css?ver=10">
<style type = "text/css">
*{
	font-family: 'Noto Sans', sans-serif;
	font-weight : bold;
}
</style>
<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script type = "text/javascript">
	$(function(){
		createTable(1);
		if("${user}"){
			$("#logInOut",parent.document).text("로그아웃");
		}else{
			$("#logInOut",parent.document).text("로그인");
		}
	});
	function searchFunc(){
		var option = $("#option").val();
		var info = $("#info").val();
		if(!info){
			window.location.reload();
		}
		var table = $("#boardList");
		$.ajax({
			url : "board?cmd=optionList",
			type : "POST",
			dataType : "json",
			data : {"option" : option, "info" : info},
			success : function(data){
				clearList();
				var cnt = 1;
				for(var brd in data){
					var tr = $("<tr>");
					$("<td>").text(cnt).appendTo(tr);
					cnt++;
					var aTag = $("<a>").attr("href","mainForm");
					
					$("<td class = 'title'>").text(data[brd].title).css("color","black").css("text-decoration","none").appendTo(aTag);
					
					aTag.appendTo(tr);
					$("<td class = 'writer'>").text(data[brd].writer).appendTo(tr);
					$("<td class = 'view'>").text(data[brd].viewCount).appendTo(tr);
					tr.appendTo(table);
				}
		//		window.location.reload();
			}
		});
	};
	function createTable(page=1){
		var table = $("#boardList");
		clearList();
		clearNavi();
		$.ajax({
			url : "board?cmd=reqList&page="+page,
			type : "POST",
			dataType : "json",
			success : function(data){				
				var brdList = data.brdList;
				var cnt = 1;
				for(var i in brdList){
					var tr = $("<tr>");
					$("<td>").text(cnt).appendTo(tr);
					cnt++;
					var aTag = $("<a class = 'title_link'>").attr("href","board?cmd=boardView&option="+brdList[i].b_id+"&cnt="+brdList[i].viewCount);
					$("<td class = 'title'>").text(brdList[i].title).css("color","black").css("text-decoration","none").appendTo(aTag);
					aTag.appendTo(tr);
					$("<td>").text(brdList[i].writer).appendTo(tr);
					$("<td>").text(brdList[i].viewCount).appendTo(tr);
					tr.appendTo(table);
				}
				
				var div_wrap = $("#navi_wrap");
				var div = $("<div id = 'navi'>");
				$("<a class = 'nav'>").attr("href","javascript:createTable()").text("처음").appendTo(div);
				for(var i = data.startPage; i <= ( data.endPage < data.pageTotalCount ? data.endPage : data.pageTotalCount ); i++){
					if(i == data.currentPage){
						$("<b class = 'nav'>").text(i).appendTo(div);
					}else{
						var aLink = $("<a class = 'nav'>").attr("href","javascript:createTable("+i+" );").text(i).appendTo(div);
					}
				}
				if(data.endPage < data.pageTotalCount){
					var aLink = $("<a class = 'nav'>").attr("href","javascript:createTable("+(data.endPage+1)+");").text("다음");
					aLink.appendTo(div);
				}
				$("<a class = 'nav'>").attr("href","javascript:createTable("+data.pageTotalCount+")").text("마지막").appendTo(div);
				div.appendTo(div_wrap);
			},
			error : function(){
				alert("fail");
			}
		});
	};
	function clearNavi(){
		$("#navi").remove();
	};
	function clearList(){
		$("#boardList tr:gt(0)").remove();
	};
</script>

</head>
<body>
	<div id = "listWrap" align = "center">
		<table id = "boardList">
			<colgroup>
				<col width = "80"/>
				<col width = "200"/>
				<col width = "100"/>
				<col width = "100"/>
			</colgroup>
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
			<button id = "search_btn" onclick = "searchFunc();">검색</button>
			<button id = "write_btn" onclick = "location.href = 'board?cmd=writePage'">글 쓰기</button>
		</div>
		<br>
		<div id = "navi_wrap">
		</div>
	</div>
</body>
</html>