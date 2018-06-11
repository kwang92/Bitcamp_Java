$(function(){
	$("#board").mousedown(function(){
		$("#target").attr("src","boardList.jsp");
		$("#aside_wrap").css("display","block");
	});
	$("#myPage").mousedown(function(){
		$("#target").attr("src","myPage.jsp");
		$("#aside_wrap").css("display","none");
	});
	$("#logInOut").mousedown(function(){
		alert($("#logInOut").text());
		if($("#logInOut").text() == "로그인"){
			$("#target").attr("src","loginForm.jsp");
		}else{
			location.href = "logout";
		}
	});
});