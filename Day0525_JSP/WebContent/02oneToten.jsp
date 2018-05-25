<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
	int num1, num2;
	public int getSum(int num){
		int sum = 0;
		for(int i = 1; i <= num; i++){
			sum += i;
		}
		
		return sum;
	}
	public int mulNums(){
		Scanner input = new Scanner(System.in);
		num1 = input.nextInt();
		num2 = input.nextInt();
		
		return num1 * num2;
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script type="text/javascript">
	$(function(){
		$(document).on({
			"keydown":function(e){
				if(e.keyCode == 13){
					var num1 = Number($("#num1").val());
					var num2 = Number($("#num2").val());
					$("#res").val(num1*num2);
				}
			}
		});
		
	});
</script>
<title>1부터 10까지의 합 jsp로</title>
</head>
<body>
	<%-- 1부터 10까지 더하는 프로그램을 작성, 
		스크립트 사용하기
		1. 스크립트릿 (scriptlet)   - 스크립트 안에서 변수를 선언하면 지역변수로 선언된다.
		2. 표현부 (expression)
		3. 선언부 (declaration)	- 선언부에 변수를 선언하면 변환되는 서블릿의 멤버변수로 선언
	--%>

	<p style = "font-size : 1.5em">
		<%= num1 %>과 <%= num2 %>의 곱은 <%= mulNums() %>입니다.
	</p>
	<%
		out.print(num1 + " * "+num2 + " = " + mulNums());
	
	%>
	<label for="num1">숫자1 입력 : </label>
	<input type="text" name="num1" id="num1">
	<label for="num2">숫자2 입력 : </label>
	<input type="text" name="num2" id="num2">
	<label for="res">결과 : </label>
	<input type="text" name="res" id="res">

</body>
</html>