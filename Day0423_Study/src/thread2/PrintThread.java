package thread2;

public class PrintThread extends Thread{
	// 타겟 스레드값 출력할 스레드
	// 쓰레드의 상태 값 받아오는 메서드 -> getState();
	Thread targetThread;
	
	public PrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}
	public void run() {
		
		
		while(true) {	//계속 반복하면서 쓰레드의 상태 값 확인
			Thread.State stat = targetThread.getState();
			
			System.out.println("타겟 스레드의 상태 : "+stat);
			if(stat == Thread.State.NEW) {
				targetThread.start();
			}else if(stat == Thread.State.TERMINATED) {
				break;
			}
			
			/*
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		
	}
}