
public class ThreadTest3 {
	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();
		Thread tr1 = new Thread(mr);
		tr1.start();
		
		
		
		for(int i = 0; i < 100; i++) {
			System.out.println("메인쓰레드 : " + i);
		}
		
	}
}
