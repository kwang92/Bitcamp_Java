
public class ExceptionTest {
	public static void main(String[] args) {
		int[] num = new int[3];
		int b = 0;
		for(int i = 0; i < 4; i++) {
			try {
				num[i] = num[i] / b;
				System.out.println(i);

			}catch(ArithmeticException | NullPointerException e) { // catch안의 예외종료는 or연산(|)으로 묶어서 처리할 수 있음.
				System.out.println("0으로 못나눔");
				System.out.println("또는 널포인터 참조");
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("배열 인덱스 예외");
			}catch(Exception e) {
				System.out.println("뭔가 예외가 발생");
			}
		}
	}
}