import java.util.Scanner;

public class Add2_Program {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1, num2, sum;
		
		System.out.print("num1값 입력: ");
		num1 = input.nextInt();
		
		System.out.print("num2값 입력: ");
		num2 = input.nextInt();
	
		sum = num1 + num2;
		
		System.out.println("두 수의 합 결과는 " + sum + "입니다.");
		
		input.close();
	}
}