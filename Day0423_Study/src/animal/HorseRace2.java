package animal;

public class HorseRace2 {
	public static void main(String[] args) {
		Horse2 h1 = new Horse2("얼룩이");
		Horse2 h2 = new Horse2("점박이");
		Horse2 h3 = new Horse2("토실이");
		Horse2 h4 = new Horse2("왕눈이");
		Horse2 h5 = new Horse2("날쌩이");
		
		Thread t1 = new Thread(h1);
		Thread t2 = new Thread(h2);
		Thread t3 = new Thread(h3);
		Thread t4 = new Thread(h4);
		Thread t5 = new Thread(h5);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
