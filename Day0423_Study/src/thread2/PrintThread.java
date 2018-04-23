package thread2;

public class PrintThread extends Thread{
	// 타겟 스레드값 출력할 스레드
	// 쓰레드의 상태 값 받아오는 메서드 -> getState();
	Thread targetThread;
	
	public PrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}
	public void run() {
		this.targetThread.start();
		
		while(true) {	//계속 반복하면서 쓰레드의 상태 값 확인
			System.out.println(this.targetThread.getState());
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}