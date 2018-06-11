var flag = 0;

$(function(){
	
	$("#id").blur(function(){
		if(!$("#id").val()){
			$(".needId").text("아이디는 필수입력 사항입니다").css("color","red");
		}
		else{
			var idExp = /^[A-Za-z0-9]{6,15}$/; 
			if((idExp.test($("#id").val()))){
				$(".needId").text("");
			}else{
				$(".needId").text("아이디는 6자이상 15자 이하로 가능합니다.").css("color","red");
				$("#id").val("");
			}
			
		}
	});
	$("#pw1").blur(function(){
		if(!$("#pw1").val()){
			$(".needPw1").text("비밀번호는 필수입력 사항입니다").css("color","red");
		}else{
			var pwExp = /^[A-Za-z0-9]{8,24}$/;
			if((pwExp.test($("#pw1").val()))){
				$(".needPw1").text("");
			}else{
				$(".needPw1").text("비밀번호는 최소 8자 이상이여야 합니다.").css("color","red");
				$("#pw1").val("");
			}
		}
		
	});
	$("#pw2").blur(function(){
		if(! ( $("#pw1").val() === $("#pw2").val())){
			$(".needPw2").text("비밀번호가 서로 일치하지 않습니다").css("color","red");
		}
		else{
			$(".needPw2").text("");
		}
	});

});


function submitCheck(){
	if($("#id").val() && $("#pw1").val() && $("#pw2").val()){
		return true;
	}
	
	return false;
}
	
function clicked(label){
	$(label).css("border","2px solid #01DF01").css("color","#01DF01");;
	$(".gender_op").not(label).css("border","0").css("color","black");
};
