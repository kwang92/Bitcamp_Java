import java.util.Scanner;

public class Control_Tax {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		final double HIGH_RATE = 0.36, MID_RATE = 0.27, ROW_RATE = 0.18, MINIMUM_RATE = 0.09;
	
		System.out.print("연봉을 입력하세요(만원) : ");
		int year_Money = input.nextInt();
		double tax;
	
		if(year_Money < 0) {
			System.out.println("0원 이상의 연봉을 입력해주세요");
			return;
		}
		
		if(year_Money > 8000) {
			tax = year_Money * HIGH_RATE;
		}
		else if(year_Money > 4000) {
			tax = year_Money * MID_RATE;
		}
		else if(year_Money > 2000) {
			tax = year_Money * ROW_RATE;
		}
		else {
			tax = year_Money * MINIMUM_RATE;
		}
		
		System.out.printf("소득세는 %.2f(만원)입니다.",tax);
		input.close();
	}
}
