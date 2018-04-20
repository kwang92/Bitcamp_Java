import java.util.Scanner;

public class Multiply2_Program {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1, num2, mul;

		System.out.print("num1 값 입력: ");
		num1 = input.nextInt();
		System.out.print("num2 값 입력: ");
		num2 = input.nextInt();

		mul = num1 * num2;

		System.out.println("두 수의 곱의 결과는 " + mul + "입니다.");	
		input.close();
	}
}