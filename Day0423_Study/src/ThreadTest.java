
public class ThreadTest {
	public static void main(String[] args){
		// 단일 스레드
		for(int i = 0; i < 100; i++) {
			System.out.println("반복문1 : "+i);
		}
		for(int i = 0; i < 100; i++) {
			System.out.println("반복문2 : "+i);
		}

	}

}
