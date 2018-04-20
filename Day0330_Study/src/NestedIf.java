
public class NestedIf {
	public static void main(String[] args) {
		// 중첩 if문
		int x = 8;
		
		
		if ( x <= 5 ) {
			if ( x % 2 == 0 ) {
				System.out.println("x는 5이하의 짝수");
			}
			else {
				System.out.println("x는 5이하의 홀수");
			}
		}
		else {
			if ( x % 2 == 0 ) {
				System.out.println("x는 5초과의 짝수");
			}
			else {
				System.out.println("x는 5초과의 홀수");
			}
		}
	}
}