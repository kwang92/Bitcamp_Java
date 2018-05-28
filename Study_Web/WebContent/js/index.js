var t1, t2;

$(function(){
	t1 = document.frm1.user_id;
	t2 = documnet.frm1.user_pwd;

});
function down(e){
	if(e.keyCode == 13){
		if(e.srcElement.name == "user_id"){
			$("#pwd").focus();
			return false;
		}
		else if(e.srcElement.name == "user_pwd"){
			if(t1.value == ""){
				$("#id").focus();
				return false;
			}
			frm1.submit();
		}	
	}
	
};