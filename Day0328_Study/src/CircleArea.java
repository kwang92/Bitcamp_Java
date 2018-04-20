import java.util.Scanner;

public class CircleArea {
	final static double PI = 3.14;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		int rad;
		double area;
		
		System.out.print("넓이를 구하고자 하는 원의 반지름을 입력하세요: ");
		rad = input.nextInt();
		area = rad * rad * PI; 
		
		System.out.println("반지름이 "+rad+"인 원의 넓이는 " + area + "입니다.");
		System.out.printf("반지름이 %d인 원의 넓이는 %.2f입니다.",rad,area);
		input.close();
	}
}