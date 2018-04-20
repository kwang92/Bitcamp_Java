import java.util.Scanner;

public class MonthDays {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int month, year;
		
		System.out.println("연도를 입력하세요: ");
		year = input.nextInt();
		System.out.print("월을 입력하세요: ");
		month = input.nextInt();
		int days;
		
		switch(month) {
		case 2:
			if((year%400==0) || ( ( year%4==0 ) && ( year%100 != 0))) {
				days = 29;
			}else {
				days = 28;
			}
			break;
		case 1: case 3: case 5: 
		case 7: case 8: case 10: case 12:
			days = 31;
			break;
		default:
			days = 30;
		}
		
		System.out.println(month+"월은 "+days+"까지 있습니다.");
		input.close();
	}
}