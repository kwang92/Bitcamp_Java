var flag = 0;

$("#pw2").on({
	"blur":function(){
		$("#error").css("display","block");	
	}
});
	
	
	
function clicked(label){
	$(label).css("border","2px solid #01DF01").css("color","#01DF01");;
	$(".gender_op").not(label).css("border","0").css("color","black");
};
