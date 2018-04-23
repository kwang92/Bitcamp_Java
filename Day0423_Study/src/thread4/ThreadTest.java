package thread4;

// 동기화 문제를 해결했음에도 생산자가 생산한 데이터를
// 소비자가 사용하지 못하거나 (공급과잉)
// 생산자가 데이터를 생산하지 않았는데 소비자는 데이터를 계속해서 사용하는 (공급부족) 문제가 발생 할 수 있다.
// Thread에서 자원의 불균형에 의한 문제를 해결
// Buffer를 이용
 

public class ThreadTest {
	public static void main(String[] args) {
		Buffer b = new Buffer();
		Runnable p = new Producer(b);
		Runnable c = new Customer(b);
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		
		t1.start();
		t2.start();
	}
}