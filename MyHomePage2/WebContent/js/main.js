$(function(){

	if($("#loginSession").val()){
	
		$("#logInOut").text("로그아웃");
	}
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
			location.href = "board?cmd=logout";
		}
	});
	
});
function det(){
	var current_Url = document.getElementById("target").contentWindow.location.href;
	//alert($("target").attr("src"));
	//$("#iframeID").contents().find("[tokenid=" + token + "]")
	if(current_Url.match('myPage.jsp')){
		$("#mainTitle").text("마이페이지");
		var tt = $("#target").contents().find("[id='flag']");
		tt.change(function(){
			alert("submit");
		});
	}else if(current_Url.match('boardList.jsp')){
		$("#mainTitle").text("게시판");
	}else{
		$("#mainTitle").text("메인페이지");
	}
}
