package thread4;

public class Producer implements Runnable{
	// 데이터를 만들어내느 역할
	private Buffer buffer;
	private int data;	// buffer에 집어넣을 data
	
	public Producer() {
		this.buffer = new Buffer();
	}
	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}
	public void run() {
		for(int i = 0; i < 10; i++) {
			data = i;
			System.out.println("생산자: " + data + "번 케익을 생산함");
			buffer.put(data);
			
			
			try {
				Thread.sleep((int)Math.random()*100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
