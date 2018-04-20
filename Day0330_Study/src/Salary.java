import java.util.Scanner;

public class Salary {
	public static void main(String[] args) {
		final int NORMAL_MONEY = 7530;	// 기준 근무시간 시급
		final double HARD_MONEY = NORMAL_MONEY * 1.5;	// 초과 근무시간 시급
		final int REG_HOUR = 8;	// 기준 근무시간
		Scanner input = new Scanner(System.in);
		double total_Sum;
		
		System.out.print("일한 시간 입력: ");
		int hour = input.nextInt();
		
		if(hour <= REG_HOUR) {
			total_Sum = hour * NORMAL_MONEY;
		}
		else {
			total_Sum = ( NORMAL_MONEY * REG_HOUR ) 
						+ ( (hour - REG_HOUR) * HARD_MONEY );
		}
		
		System.out.printf("총 급여는  %.2f원 입니다.\n",total_Sum);
		input.close();
	}
}
