var t1, t2;

$(function(){
	t1 = document.frm1.id;
	t2 = document.frm1.pwd;
});
function down(e){
	if(e.KeyCode == 13){
		if(e.srcElement.name == "id"){
			$("#pwd").focus();
			return false;
		}
		else if(e.srcElement.name == "pwd"){
			if(t1.value == ""){
				$("#id").focus();
				return false;
			}
			frm1.submit();
		}
	}
}
function sub_click(){
	frm1.submit();
};