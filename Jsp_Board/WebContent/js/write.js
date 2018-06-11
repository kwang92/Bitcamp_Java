
$(function(){
	var frm = boardFrm;

	$("#name").blur(function(){
		if(!$("#name").val()){
			$(".needName").text("작성자를 입력해주셔야 합니다.").css("color","red");
		}
		else{
			$(".needName").text("");
		}
	});
	$("#pass").blur(function(){
		if(!$("#pass").val()){
			$(".needPass").text("비밀번호를 입력해주셔야 합니다.").css("color","red");
		}
		else{
			$(".needPass").text("");
		}
	});
	$("#email").blur(function(){
		var mail = $("#email").val();
		if(!mail){
			$(".needEmail").text("이메일을 입력해주셔야 합니다.").css("color","red");
		}
		else{
			$(".needEmail").text("");
		}
		
		var exp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		if(exp.test(mail) == false){
			var text = $(".needEmail").text();
			$(".needEmail").text(text+" 올바른 이메일 형식을 입력해주세요").css("color","red");
		}
		else{
			$(".needEmail").text("");
		}
	});
});

function submitCheck(){
	if($("#name").val() && $("#pass").val() && $("email").val()){
		return true;
	}
	alert("형식을 모두 입력해주세요");
	return false;
}
