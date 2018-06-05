<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

th {
	background-color: lightgray;
}

th, td {
	border: 1px solid lightgray;
}

#wrap {
	width: 100%;
	margin-top: 50px;
}

#list {
	width: 780px;
	margin: 0 auto;
}

#list td {
	padding: 3px;
}

.info {
	width: 60px;
}

form {
	width: 580px;
	margin: 0 auto;
}

textarea {
	width: 97%;
	height: 300px;
	margin: 10px;
}

#input {
	width: 100%;
}

#input th {
	width: 80px;
}

#end {
	border: 0;
	text-align: right;
}

form p {
	text-align: right;
}

input {
	border: 0;
}

.pass_form {
	width: 98%;
	height: 100%;
}
#navi{
	width : 780px;
	margin : 0 auto;
	text-align : center;
}
.del_input {
	width: 80px;
	border: 1px solid black;
}

.input_td {
	width: 130px;
}

ul {
	list-style-type: none;
}

.bb {
	width: 100px;
	height: 300px;
}
</style>
</head>
<body>
	<div id="wrap">
		<table id="list">
			<tr>
				<th class="info">번호</th>
				<th>내용</th>
				<th class="info">글쓴이</th>
				<th></th>
			</tr>
			<c:forEach items="${viewData.messageList}" var="msg">
				<tr>
					<th>${msg.id}</th>
					<td>${msg.message}</td>
					<td style="text-align: center">${msg.name}</td>
					<td class="input_td">
						<form action="del" class="pass_form">
							<input type="hidden" name="id" value="${msg.id}"> <input
								type="password" name="pwd" class="del_input"
								placeholder="password" style="text-align: center">
							<button onclick="this.submit()">삭제</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<div id="navi">
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
		<br>
		<hr>
		<br>
		<form action="write" method="POST">
			<table id="input">
				<tr>
					<th>이름</th>
					<td><input type="text" placeholder="이름을 입력하세요" name=name></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" placeholder="비밀번호를 입력하세요"
						name=password></td>
				</tr>
				<tr>
					<th colspan="2">내용</th>
				</tr>
				<tr>
					<td colspan="2" rowspan="2"><textarea name="context">		
						</textarea></td>
				</tr>
			</table>
			<p>
				<input type="submit" value="작성"
					style="border: 1px solid gray; padding: 5px">
			</p>
		</form>
	</div>
</body>
</html>