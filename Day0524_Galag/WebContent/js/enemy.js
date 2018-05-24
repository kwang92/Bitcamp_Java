/*
 * 적선 객체에 대한 선언
 */
function Enemy(parent,posX,posY,width,height,src,hp,speed){
	/* 적선을 그리기 위한 속성값,
	 * 좌표(x위치,y위치)크기(너비,높이)
	 * 적선이 그려 질 부모요소
	 * */
	this.parent = parent;
	this.posX = posX;
	this.posY = posY;
	this.width = width;
	this.height = height;
	this.src = src;
	this.hp = hp;
	//실제 적선이 그려질 요소 변수
	this.span;
	this.img;
	this.speed = speed;
	
	
	//초기화 함수 : 적선 요소 생성, 생성 후 부모요소에 붙이기 
	this.init = function(){
		this.span = $("<span></span>").width(this.width+"px")
		.height(this.height+"px");
		this.span.css({
			"position" : "absolute",
			"top"  :this.posY+"px",
			"left" :this.posX+"px"
		});
			
		this.img = $("<img>").attr("src",this.src)
		.width(this.width +"px").height(this.heigth+"px");
		
		//요소1.append(요소2); : 요소2를 요소1의 하위요소로 추가
		this.span.append(this.img);
		//만들어낸 span요소를 부모요소(content)에 붙이기
		this.parent.append(this.span);
	}
	this.move = function(){
		//특정 값 만큼만 이동
		var me = this;
		this.posY = this.posY + this.speed; 
		
		this.span.css("top",this.posY+"px");
		
		//총알이 밖으로 나가면 없애주기
		if(this.posY > 700){
			this.span.remove(); //현재 요소 삭제
			return;
		}

		setTimeout(function(){
			me.move();
		},100);
	}
	
}