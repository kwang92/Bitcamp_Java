<%@page import="model.Loan"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/res.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>회차</th>
			<th>상환액</th>
			<th>상환원금</th>
			<th>이자</th>
			<th>상환총액</th>
			<th>잔액</th>
		</tr>
		<%
			ArrayList<Loan> list;
			list = (ArrayList<Loan>)(request.getAttribute("data"));
			
			for(int i = 0; i < list.size(); i++){
				%>
		<tr>
			<td><%= list.get(i).getNum() %></td>
			<td><%= list.get(i).getRepayTotal() %></td>
			<td><%= list.get(i).getRepayOrigin() %></td>
			<td><%= list.get(i).getInterest() %></td>
			<td><%= list.get(i).getRepaySum() %></td>
			<td><%= list.get(i).getRepayRemain() %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>