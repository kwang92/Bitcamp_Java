package animal;

import java.util.Random;

public class Horse2 extends Animal implements Runnable{
	private String name;
	private int ranNum;
	private Random ran;
	
	public Horse2(String name) {
		ran = new Random();
		this.name = name;
	}
	public void run() {	// Runnable 메서드 구현
		int sum = 0;
		while(sum < 50) {
			sum += getNum();
		//	System.out.println(name+"달리는중...."+" "+sum+"m");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(name+" 도착!!");
	}
	public void createRand() {
		ranNum = ran.nextInt(5)+1; 
	}
	public int getNum() {
		createRand();
		return this.ranNum;
	}
}
