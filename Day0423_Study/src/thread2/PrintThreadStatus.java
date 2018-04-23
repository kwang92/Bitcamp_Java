package thread2;

public class PrintThreadStatus {
	// 스레드 진행에 따른 상태 값 출력
	public static void main(String[] args) {
		// 파생스레드 2개 생성 -> 출력스레드, 타겟 스레드
		// 출력스레드 : 타겟스레드의 상태값을 출력,   타겟스레드 : 실행할 스레드
		TargetThread b = new TargetThread();
		PrintThread a = new PrintThread(b);
		a.start();
	}
}
