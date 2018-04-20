import java.util.Scanner;

public class Operator6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int year;
		String leaf;
		System.out.print("연도를 입력하세요: ");
		year = input.nextInt();
		
		// 윤년조건 
		// 1. 4로 나누어 떨어지면서 100으로 나누어 떨어지지않음
		// 2. 400으로 나누어 떨어짐  둘중 하나라도 만족하면 윤년
		
		leaf = ( (year%400==0) || ( ( year%4==0 ) && ( year%100 != 0)) )
				?"윤년입니다.":"윤년이 아닙니다.";
		
		System.out.println(year+"년은 "+leaf);
		input.close();
	}
	public static void useIf() {
		
	}
}
