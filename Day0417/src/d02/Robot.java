package d02;

public  abstract class Robot {
	protected String name;
	
	public Robot() {
		
	}
	public void fight() {
		System.out.println(name+" 전투시작");
		attack();
		move();
		attack();
		System.out.println(name+" 전투종료");
	}
	public abstract void attack();
	public abstract void move();
}
