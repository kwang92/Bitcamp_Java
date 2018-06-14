var flag = 0;

var idFlag = false;
var pwFlag = false;
var mailFlag = false;
$(function(){
	
	$("#id").blur(function(){
		if(!$("#id").val()){
			$(".needId").text("아이디는 필수입력 사항입니다").css("color","red");
			idFlag = false;
		}
		else{
			var idExp = /^[A-Za-z0-9]{6,15}$/; 
			if((idExp.test($("#id").val()))){
				$(".needId").text("");
				var checkVal = "id"+($("#id").val());
				if(checkValue(checkVal) == false ){
					$(".needId").text("중복된 아이디입니다.").css("color","red");
					idFlag = false;
				}else{
					$(".needId").text("");
					idFlag = true;
				}
			}else{
				$(".needId").text("아이디는 6자이상 15자 이하로 가능합니다.").css("color","red");
				idFlag = false;
			}
			
		}
	});
	$("#pw1").blur(function(){
		if(!$("#pw1").val()){
			$(".needPw1").text("비밀번호는 필수입력 사항입니다").css("color","red");
			pwFlag = false;
		}else{
			var pwExp = /^[A-Za-z0-9]{8,24}$/;
			if((pwExp.test($("#pw1").val()))){
				$(".needPw1").text("");
				pwFlag = true;
			}else{
				$(".needPw1").text("비밀번호는 최소 8자 이상이여야 합니다.").css("color","red");
				pwFlag = false;
			}
		}
		
	});
	$("#pw2").blur(function(){
		if(! ( $("#pw1").val() === $("#pw2").val())){
			$(".needPw2").text("비밀번호가 서로 일치하지 않습니다").css("color","red");
			pwFlag = false;
		}
		else{
			$(".needPw2").text("");
			pwFlag = true;
		}
	});

});

function checkValue(value){
	$.ajax({
		url : "page?cmd=checkInput",
		type : "post",
		data : {"data" : value},
		dataType : "json",
		success : function(result){
			if(result.res){	// 가입가능
				return true;	
			}else{	// 아이디 중복
				return false;
			}
		},
		error : function(){
			alert("체크벨류 에러");
		}
	
	});
};
function submitCheck(){
	if(idFlag && pwFlag){
		return true;
	}
	alert("조건을 충족해주세요");
	return false;
}
	
function clicked(label){
	$(label).css("border","2px solid #01DF01").css("color","#01DF01");;
	$(".gender_op").not(label).css("border","0").css("color","black");
};
