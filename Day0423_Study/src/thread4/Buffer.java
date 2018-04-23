package thread4;

/*
 * 	wait(), notify()
 *  wait() : 쓰레드의 진행을 멈춤  ( notify()를 받을 때 까지 )
 *  notifyAll() : 자원을 모두 사용했음을 다른 쓰레드에게 알려줌
 */

public class Buffer {
	private int data;
	private boolean empty;
	
	public Buffer() {
		empty = true;
	}
	public synchronized int get() {	// 자원이 없으면 가져가지 않아야함, 생산자가 자원을 만들었음을 알려 줄 때 까지 기다렸다가 
		while(empty == true) {// 자원이 없다면	// 자원을 생상했다고 알려주면, 자원을 가져가고 자원을 가져갔다고 알려줌
			try{
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		//empty == false가 되면 밑의 line 실행 (데이터가 생산됨)
		empty = true;
		notifyAll();
		return data;
	}
	public synchronized void put(int data) {	// 자원이 충분하면 자원을 생성하지 않는다.
		while(empty == false) {// 자원이 있다면
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		// empty == true가 되면 밑의 line 실행 (데이터가 소비됨)
		this.data = data;
		empty = false;
		
		notifyAll();
	}
}
