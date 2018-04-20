
public class Operator2 {
	public static void main(String[] args) {
		// 연산자  - 관계연산자 return 값으로 항상 true나 false가 반환된다.
		// == , !=, >, <, >=, <=
		int x = 5, y = 3;
		
		System.out.println(x == y);
		System.out.println(x != y);
		System.out.println(x > y);
		System.out.println(x < y);
		System.out.println(x <= y);
		System.out.println(x >= y);
		
		// 논리연산 ( &&, ||, ! ), 비트연산 ( &, |, ^ )
		System.out.println("======");
		System.out.println(true && false);
//		System.out.println(true || false);
		System.out.println(!true);
		
		System.out.println("======");
		System.out.println(x & y);
		System.out.println(x | y);
		System.out.println(x ^ y);
	}
}
