package Interface1;

public class InterfaceTest{
	public static void main(String[] args) {
		Moveable[] m = new Moveable[2];	// 인터페이스이므로 객체생성이 안됨 ( 상속용으로만 사용한다 )
										// 인터페이스 사용예제
		m[0] = new Dog();
		m[1] = new Cat();
		
		for(Moveable m1 : m) {
			m1.move();
		}
		
	}
}
