$(function(){
	//alert($("#target").contents().find("#profile_Img")[0].tagName);

	/*
	divimg.addEventListener("DOMAttrModified", function(event) {
	    if (event.attrName == "src") {
	       alert("이미지 바뀜")
	    }
	});
	*/
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
	//		location.href = "imageReq";
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
		var tt = $("#target").contents().find("[id='flag']");
		tt.change(function(){
			alert("submit");
		});
		

	}
}
