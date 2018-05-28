<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel= "stylesheet" type="text/css" href="./css/loan.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

			<form id = "myFrm" action ="loanResult.jsp">
				<table>
					<tr>
						<th>대출원금</th>
						<td><input type = "text" name = "price" placeholder = "금액입력"></td>
						<th>원</th>
					</tr>
					<tr>
						<th>대출이율</th>
						<td><input type = "text" name = "rate" placeholder = "이율입력"></td>
						<th>%</th>
					</tr>
					<tr>
						<th>대출기간</th>
						<td><input type = "text" name = "period" placeholder = "기간입력"></td>
						<th>개월</th>
					</tr>
					<tr>
						<td colspan = "3">
							<label><input type = "radio" name = "type" value = "1" checked>원금 균등상환</label>
							<label><input type = "radio" name = "type" value = "2">원리금 균등상황</label>
						</td>
					</tr>
					<tr>
						<td colspan = "3">	
							<input type = "submit" value = "계산">
							<input type = "reset" value = "초기화">
						</td>
					</tr>
				</table>
			</form>

</body>
</html>