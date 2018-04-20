package d03;

public class Gundam extends Robot{
	public Gundam(Attackable attack, Moveable move) {
		this.name = "건담";
		this.attack = attack;	// robot 클래스로부터 상속받은 Attackable 인터페이스 변수에 attack을 넣어준다.
		this.move = move;		// robot 클래스로부터 상속받은 moveable 인터페이스 변수에 move를 넣어준다.
	}
	public void move() {	// robot 추상클래스 move 메서드 구현
		move.move();
	}
	public void attack(){	// robot 추상클래스 attack 메서드 구현
		attack.attack();
	}
}
