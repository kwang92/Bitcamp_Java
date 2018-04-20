// 변수의 유효범위는 선언된 블록내에서만 적용되고 
// 지역변수가 우선 된다.

public class Variables {
	int a = 3;
	
	public void method1() {
		int a = 5;
	}
	public void method2() {
		int a = 7;
	}
}
