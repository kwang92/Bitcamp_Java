import java.util.Scanner;

public class Salary_Program {
	public static void main(String[] args) {
		// 저축액을 계산하는 프로그램 저축액을 입력받아서 10년동안 저축액을 구하는 프로그램 
		// 단, 10년동안 같은 금액을 저축
		Scanner input = new Scanner(System.in);
		int month_Money, total_Money, save_Month = 10;
		final int MONTH_FOR_YEAR  = 12;
		
		System.out.print("월 저축액을 입력하세요: ");
		month_Money = input.nextInt();
		total_Money = month_Money * MONTH_FOR_YEAR * save_Month;
		
		System.out.println(save_Month+"년  총 저축액은 " + total_Money + "원입니다.");
		
		input.close();
	}
}
