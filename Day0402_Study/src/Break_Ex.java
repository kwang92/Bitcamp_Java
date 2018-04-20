import java.util.Scanner;

public class Break_Ex {
	public static void main(String[] args) {
		/*
		 * break 연습
		 * 반복문을 빠져 나올때 사용 ( 반복문의 조건과 상관없이 가능 )
		 */
		Scanner input = new Scanner(System.in);
		int num;
		
		while(true) {
			System.out.print("숫자를 입력하세요 : ");
			num = input.nextInt();
			if(num == -1) {
				System.out.println("종료합니다.");
				break;
			}
			System.out.printf("%d * 2 = %d\n\n",num,num*2);
		}
		input.close();
	}
}