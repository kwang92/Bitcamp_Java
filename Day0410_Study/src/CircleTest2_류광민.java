import java.util.Scanner;

public class CircleTest2 {
	public static void main(String[] args) {
		// 사용자로부터 다수의 원의 반지름과 중심점의 좌표를 입력받아서
		// 출력하는 프로그램을 작성하라
		
		Scanner input = new Scanner(System.in);
		System.out.print("저장할 원의 개수를 입력하세요 : ");
		int num = input.nextInt();
		Circle[] circle= new Circle[num];
		
		
		for(int i = 0; i < num; i++) {
			int r, x, y;
			System.out.print("원의 반지름 입력 : ");
			r = input.nextInt();
			System.out.print("원의 x좌표 입력 : ");
			x = input.nextInt();
			System.out.print("원의 y좌표 입력 : ");
			y = input.nextInt();
			
			circle[i] = new Circle(new Point(x,y),r);
		}
		
		for(int i = 0; i < circle.length; i++) {
			System.out.println("원 "+(i+1)+"의 "+circle[i]);
		}
		input.close();
	}
}
