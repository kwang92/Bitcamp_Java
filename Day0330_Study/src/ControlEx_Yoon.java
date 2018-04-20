import java.util.Scanner;

public class ControlEx_Yoon {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int year;
		
		System.out.print("연도를 입력하세요: ");
		year = input.nextInt();
		
		if((year%400==0) || ( ( year%4==0 ) && ( year%100 != 0))){
			System.out.println("윤년 입니다.");
		}
		else {
			System.out.println("윤년이 아닙니다.");
		}
		input.close();
	}
}
