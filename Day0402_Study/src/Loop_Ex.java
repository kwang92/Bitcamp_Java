

public class Loop_Ex {
	public static void main(String[] args) {
		/*
		 * 반복문 - while, for, do while
		 * 
		 * while 	: 조건식이 만족할 때, 계속해서 반복
		 * for	 	: 보통 반복하는 횟수가 정해져 있을 때 사용
		 * do while : while과 동일하나, 최초 1번은 실행
		 * 
		*/
		
		/*
		int x = 1;
		
		while(x <= 10) {
			System.out.println("Hello world!! "+(x*2));
			x++;
		}
		*/
		
		// 예제 1. 1부터 10 까지의 합을 출력하는 프로그램을 작성하라. 단, while문 사용
		/*
		int sum = 0, cnt = 1;
		while(cnt <= 10) {
			sum += cnt++;
		}
		System.out.println("총 합은 "+sum+"입니다.");*/
		
		// 예제 2. 사용자에게 입력받은 수 만큼 반복해서 더하기
		/*
		Scanner input = new Scanner(System.in);
		System.out.print("숫자 입력: ");
		int cnt = input.nextInt();
		int sum = 0, i = 1;
		
		while(i <= cnt) {
			sum += i++;
		}
		System.out.println("1부터 "+cnt+"까지의 총합은 "+sum+"입니다.");
		input.close();*/
	}
	
}