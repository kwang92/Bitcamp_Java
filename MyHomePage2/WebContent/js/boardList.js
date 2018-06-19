function openProfile(url){
	
	var cw = 400;
	var ch = 400;
	var sw = window.screen.availWidth;
	var sh = window.screen.availHeight;
	var px = (sw/2)-(cw/2);
	var py = (sh/2)-(ch/2);
	var specs = 'height=400, width=400, left='+ px + ', top='+ py + ', screenX='+ px + ', screenY= '+ py;


	window.open(url,"123",specs);
}