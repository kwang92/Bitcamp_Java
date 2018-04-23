package horse;

import java.util.Random;

public class Horse extends Thread{
	private String name;
	private int ranNum;
	private Random ran;
	
	public Horse(String name) {
		ran = new Random();
		this.name = name;
	}
	public void run() {
		int sum = 0;
		while(sum < 50) {
			sum += getNum();
			System.out.println(name+"달리는중...."+" "+sum+"m");
			try {
				Thread.sleep(200);
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
