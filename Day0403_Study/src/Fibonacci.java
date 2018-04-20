import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		/*	피보나치 수열 만들기
		 * 사용자로부터 정수 하나 입력받아서 수만큼의 피보나치 수열을 출력
		 * */
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int sum1 = 0, sum2 = 1, sum3 = 0;
		
		for(int i = 0; i < num; i++) {
			sum3 = sum1 + sum2;
			System.out.print(sum1+" ");
			sum1 = sum2;
			sum2 = sum3;
		}		
		
		input.close();
	}
}