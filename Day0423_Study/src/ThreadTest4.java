
public class ThreadTest4 {	// Thread Runnable 버젼
	public static void main(String[] args) {
		
		Runnable r1 = new Runnable() {
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println("hello1");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		// r1과 r2는 똑같은 기능임 r2는 람다식
		
		Runnable r2 = ()->{
			for(int i = 0; i < 10; i++) {
				System.out.println("hello2");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		
		
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}
