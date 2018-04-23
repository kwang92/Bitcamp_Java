package thread2;

public class TargetThread extends Thread{
	// 이 스레드의 상태값을 PrintThread가 출력

	public void run() {
		for(long i = 0; i < 2000000000; i++) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for(long i = 0; i < 2000000000; i++) {

		}
	}
}