package d03;

public abstract class Robot {
	protected String name;
	Attackable attack;	// attack 변수에 각 맞는 무기기능 담기
	Moveable move;	// move변수에 각 맞는 움직임기능 담기
	
	public void fight() {
		System.out.println(name+" 전투시작");
		attack();
		move();
		attack();
		System.out.println(name+" 전투종료");
	}
	public abstract void move();
	public abstract void attack();
}