
public class Teset {
	public static void main(String[] args) {
		int a = 5, b = 0;
		
		try {
			System.out.println(a/b);
		}catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다");
		}
		
		Test[] c = new Test[3];
		
		try {
			c[0].display();
		}catch(NullPointerException e){
			System.out.println("객체없음");
		}
		
		System.out.println("정상종료");
	}
}