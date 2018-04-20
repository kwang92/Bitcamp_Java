import java.util.Scanner;

public class Break_Ex2 {
	public static void main(String[] args) {
		// 사용자에게 정수를 입력받으면 해당 정수의 배수를 출력하다가
		// 100이 넘어가면 종료

		Scanner in = new Scanner(System.in);
		int num;

		do {	// 문제 숫자 예외처리
			System.out.print("숫자를 입력하세요: ");
			num = in.nextInt();
		}while(num <= 0);
		
		for(int i = 1; ;i++) {
			System.out.print(num*i+" ");

			if(num * i > 100) {
				break;
			}
		}
		/*
		for(int i = 1; (num * i) < 100; i++) 
			System.out.print(num*i+" ");
		 */
		in.close();
	}
}
