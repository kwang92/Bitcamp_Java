package thread4;

public class Customer implements Runnable{
	private Buffer buffer;
	private int data;
	
	public Customer() {
		this.buffer = new Buffer();
	}
	public Customer(Buffer buffer) {
		this.buffer = buffer;
	}
	public void run() {
		for(int i = 0; i < 10; i++) {
			data = buffer.get();
			System.out.println("소비자 : " + data + "번 케익을 소비");
			try {
				Thread.sleep((int)Math.random()*100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}