
public class Operator4 {
	public static void main(String[] args) {
		// 연산자 - 비트연산자, 삼항연산자
		
		int x = 3, y = 7;
		
		System.out.println(x & y);	// 둘 다 1이면 1 아니면 0
		System.out.println(x | y);	// 둘중 하나라도 1이면 1
		System.out.println(x ^ y);	// 같으면 0 다르면 1
		System.out.println(~y); // +1한 후 부호반전
		
		// 쉬프트연산은 좌측으로 쉬프트할때 마다 곱하기 2
		
		int z = (x>y)?x:y;
		System.out.println(z);
	}
}
