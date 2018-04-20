import java.util.Scanner;

public class While_Ex2 {
	public static void main(String[] args) {
		// 반복계수 : 반복문 시작전에 초기화되며, 반복문안에서 변하면서 반복문의 조건문을 변화시키는 변수
		
		Scanner input = new Scanner(System.in);	// Scanner 객체 생성
		
		System.out.print("수 입력: ");
		int num = input.nextInt();	// 사용자에게 입력받을 정수를 저장할 변수
		int i = 1;	// while문 초기 값
		while(i <= num) {
			if(i % 2 == 0) {	// i 값이 짝수일 때의 조건
				System.out.printf("%2d ",i);
			}
			i++;	// i 변수를 1씩 증가
		}
		
		input.close();
	}
}