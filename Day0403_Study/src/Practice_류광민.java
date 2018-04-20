import java.util.Scanner;

public class Practice_류광민 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int s, e;
		
		while(true){
			s = input.nextInt();
			e = input.nextInt();
			
			if(  ( s >= 2 && s <= 9 ) && ( e >= 2 && e <= 9 ) ) {	// s, e 값의 범위 검사 후 만족하면 break
				break;
			}
			System.out.println("INPUT ERROR!");	// 조건문에 걸리지 않고 내려 올 시 INPUT ERROR 출력
		}
	
		if(s < e) {	// e의 값이 s보다 클 때
			for(int i = 1; i < 10; i++) {
				for(int j = s; j <= e; j++) {
					System.out.printf("%d *%2d = %2d   ",j,i,i*j);
				}
				System.out.print("\n");
			}
		}
		else {	// s의 값이 e 보다 클 때
			for(int i = 1; i < 10; i++) {
				for(int j = s; j >= e; j--) {
					System.out.printf("%d *%2d = %2d   ",j,i,i*j);
				}
				System.out.print("\n");
			}
		}
	}
}