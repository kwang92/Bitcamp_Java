import java.util.Scanner;

public class ControlEx_HallZZack {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number;
		
		System.out.print("숫자를 입력하세요: ");
		number = input.nextInt();
		
		if(number % 2 == 0) {
			System.out.println("짝수입니다.");
		}
		else {
			System.out.println("홀수입니다.");
		}
		
		input.close();
	}
}
