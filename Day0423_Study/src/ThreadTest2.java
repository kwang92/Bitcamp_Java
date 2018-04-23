
public class ThreadTest2 {
	public static void main(String[] args) {
		Thread tr1 = new MyThread();
		tr1.start();
		
		for(int i = 0; i < 100; i++) {
			System.out.println("메인스레드: "+i);
		
		}
		System.out.println("메인스레드 종료");
		
	}
}