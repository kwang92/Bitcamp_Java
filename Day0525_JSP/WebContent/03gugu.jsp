<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type = "text/css">
	td{
		padding : 5px;
		text-align : center;
	}
	table{
		border : 0;
	}
	tr,td	{
		border : 1px solid #000000;
	}
	.br{
		border : 0;
	}
</style>
<title>구구단 출력하기 </title>
</head>
<body>
	<%! 
		
	%>
	<table>
	<%
		for(int i = 0; i < 3; i++){
			for(int j = 1; j < 10; j++){
				%>
				<tr>
				<%
				for(int k = 3*i+1; k <= 3*i+3; k++){
					%>	
						<td colspan = "5"><%= k %> * <%= j %> = <%= k*j %></td>			
					<% 
				}
				%></tr><%
			}
			%>
			<tr>
				<td class = "br" colspan = 15></td>
			</tr>
			<%
		}
	%>
	</table>
</body>
</html>