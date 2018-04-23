package horse;

public class HorseRace {
	public static void main(String[] args) {
		Thread t1 = new Horse("번개");
		Thread t2 = new Horse("적토마");
		Thread t3 = new Horse("슈팅스타");
		Thread t4 = new Horse("다크호스");
		Thread t5 = new Horse("유니콘");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
	}
}
