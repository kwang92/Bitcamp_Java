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
	<%
		String amountStr = request.getParameter("price");
		String rateStr  = request.getParameter("rate");
		String periodStr  = request.getParameter("period");
		String typeStr  = request.getParameter("type");
		
		int amount = Integer.parseInt(amountStr);
		double rate = Double.parseDouble(rateStr);
		int period = Integer.parseInt(periodStr);
		int type = Integer.parseInt(typeStr);
		
		double mRate = rate / 100 / 12;
	%>
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
		int repayTotal,repayOrigin,interest,repaySum,repayRemain; 
			repayRemain = amount;  //처음 총 잔금은 내가 빌린금액
			repaySum = 0;
			int repayMonth;
			if(type == 1){
				repayMonth = amount / period;
			} else{
				repayMonth = (int)((amount*mRate*Math.pow(1+mRate,period))
								/(Math.pow(1+mRate,period)-1));
			}
			
			for(int i = 1; i <= period; i++){
				interest = (int)(repayRemain*mRate);
				
				if(type == 1){
					//원금 균등상환
					repayTotal = repayMonth + interest;  //이번달 낼 금액의 총합
					repayOrigin = repayMonth;  //이번달 낸 원금
				}else{
					//원리금 균등상환
					repayTotal = repayMonth;
					repayOrigin = repayMonth - interest; //이번달 낸 원금
				}
				repayRemain = repayRemain - repayOrigin;
				repaySum = repaySum + repayTotal;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=repayTotal%></td>
					<td><%=repayOrigin%></td>
					<td><%=interest%></td>
					<td><%=repaySum%></td>
					<td><%=repayRemain%></td>
				</tr>
				<% 
			}
		%>
	</table>
</body>
</html>