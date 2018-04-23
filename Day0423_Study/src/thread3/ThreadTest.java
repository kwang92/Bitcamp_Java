package thread3;
/*
 * 	동기화 ( synchronization )
 *  : 스레드는 공통된 메모리공간에 함께 접근할 수 있기 때문에
 *    유용하지만 같은 데이터를 사용함으로써 동기화 문제가 발생할 수 있다.
 *  해결방법 -> 임계구역 설정 : 다른 스레드가 데이터에 대해 접근해서 사용중일 때는 사용을 금지한다.
 *            == synchronized를 메소드 반환형 앞에 붙여주면 됨
 */

public class ThreadTest {
	public static void main(String[] args) {
		BankAccount myAccount = new BankAccount();
		Runnable p1 = new User(myAccount);
		Runnable p2 = new User(myAccount);
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		
		t1.start();
		t2.start();
	}
}
