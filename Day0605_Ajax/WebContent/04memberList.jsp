<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script type = "text/javascript">
	/*
		비동기 방식으로 요청/처리 하기
		1. 아이디 확인
		2. 회원가입 후 회원목록 가져오기
	*/
	$(function(){
		$("#joinForm").on("submit",function(){
			var d = $(this).serialize();
			var command = "?command=join";
			$.ajax({
				url : "member"+command,
				type : "get",
				data : d,
				dataType : 'json',
				success : function(data){
					clearList();
					createList();
				},
				error : function(){
					alert("실패");
				}
			});
			return false; // submit의 진행을 멈춤 form 자체의 action을 막아줌
		});
		$("#userid").blur(function(){
			var id = $("#userid").val();
			var command = "?command=idCheck";
			$.ajax({
				url : "member"+command,
				type : "post",
				data : {"id" : id},
				//dataType : 'text',
				dataType : 'json',
				success : function(data){
					//$("#idresult").text(data);
					$("#idDup").text(data.res);
				}
			});
		});
		$("#email").blur(function(){
			var email = $("#email").val();
			var command = "?command=emailCheck";
			$.ajax({
				url : "member"+command,
				type : "post",
				data : {"email" : email},
				//dataType : 'text',
				dataType : 'json',
				success : function(data){
					//$("#idresult").text(data);
					$("#emailDup").text(data.res);
				}
			});
		});
		createList();
	});
	function delMember(id){
		var command = "?command=delMember";
		$.ajax({
			url : "member"+command,
			type : "post",
			dataType : "json",
			data : {"deleteId" : id},
			success : function(){
				clearList();
				createList();
			}
		});
	}
	function createList(){
		// listTable에 회원목록을 조회해서 출력하는 메소드
		var command = "?command=memberList";
		var table = $("#listTable");
		$.ajax({
			url : "member"+command,
			type : "get",
			dataType : "json",
			success : function(data){
				
				for(var i in data){
					var tr = $("<tr>");
					var id = String(data[i].id);
					$("<td>").text(data[i].id).appendTo(tr);
					$("<td>").text(data[i].email).appendTo(tr);
					$("<td>").text(data[i].name).appendTo(tr);
					var btn = $('<button onclick = "delMember(\''+id+'\');">삭제</button>');
					var td = $("<td>");
					btn.appendTo(td);
					td.appendTo(tr);
					tr.appendTo(table);
				}	
			}
		});
	
	};
	function clearList(){
		$("#listTable tr:gt(0)").remove();
	};
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name = "joinForm" method = "post" id = "joinForm">
		<table border = "1">
			<tr bgcolor = "lightgray">
				<th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th>
			</tr>
			<tr>
				<td><input type = "text" name = "userid" id = "userid"><span id = "idDup">아이디 중복여부</span></td>
				<td><input type = "password" name = "password" id = "password"></td>
				<td><input type = "text" name = "name" id = "name"></td>
				<td><input type = "text" name = "email" id = "email"><span id = "emailDup">이메일 중복여부</span></td>
			</tr>
			<tr>
				<td colspan = "4">
					<input type = "submit" value = "가입하기" id = "joinBtn">
				</td>
			</tr>
		</table>
	</form>
	<h2>회원목록</h2>
	<table id = "listTable" border = "1">
		<colgroup>
			<col width = "150px">
			<col width = "250px">
			<col width = "100px">
		</colgroup>
		<tr bgcolor = "lightgray">
			<th>아이디</th><th>이메일</th><th>이름</th><th>삭제</th>
		</tr>
	</table>
</body>
</html>