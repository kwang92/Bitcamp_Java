
public class CarTest {
	/*	Car클래스는 Tire(Interface)의 roll()을 이용해서 굴러감
	 * 	Car Tire 클래스의 객체를 가지고 사용 ( 멤버 변수 )
	 * 	Tire를 구현하는 클래스는 두 가지 방법으로 만들어본다.
	 * 		1. implements 해서 class로 작성
	 * 		2. 익명클래스로 작성
	 */
	public static void main(String[] args) {
		// Tire 객체, Car 객체만들어서 drive() 호출
		
		//Tire koreaTire = new KoreaTire();
		//Car myCar = new Car(koreaTire);
		//myCar.drive();
		
		/*
		Tire chinaTire = new Tire() {
			public void roll() {
				System.out.println("중국타이어 굴러가다가 터짐.");
			}
		};
		Car myCar = new Car(chinaTire);
		myCar.drive();
		*/
		
		/*
		Car myCar = new Car(new Tire() {
			public void roll() {
				System.out.println("중국타이어 가다가 터짐");
			}
		});
		myCar.drive();
		*/
		
		// 람다식 : 인터페이스 구현클래스를 좀 더 쉽게 작성할 수 있도록 만들어주는 표현식
		// 		( 인터페이스의 메서드가 하나일 때만 사용 가능한 표현식 )
		// 반환형 메서드이름 ()->{
		//    반환 값
		// };              이런 식으로 생김
		
		//Tire chinaTire = ()->System.out.println("중국타이어 굴러가다 터짐"); // 요것이 람다식
		
		/*
		Tire chinaTire = ()->{
			System.out.println("중국타이어 굴러가다 터짐");
		};
		*/
		Car myCar = new Car(new KoreaTire() {
			public void roll() {
				System.out.println();
			}
		});
	}
}