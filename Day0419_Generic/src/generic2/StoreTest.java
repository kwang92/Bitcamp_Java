package generic2;

public class StoreTest {
	public static void main(String[] args) {
		// 제네릭 객체는 다양한 종류의 데이터를 저장할 수 있지만,
		// 객체를 만들때 어떤 종류의 데이터를 저장할지 결정해주어야함.
		Store <String> s1 = new Store <String>();
		s1.setData("hello");
		System.out.println(s1);
		
		Store <Integer> s2 = new Store <Integer>();
		s2.setData(7);
		System.out.println(s2);
		
		// 제네릭 참조변수에 어떤 데이터 타입의 제네릭 객체가 참조 될지 모를 때
		// 와일드카드를 사용 할 수 있다.
		/*	와일드카드 종류
		 *   :   ?			-> 모든 데이터 타입의 제네릭 객체가 참조가능
		 *   :   ? super	-> 클래스 자기 자신 또는 super클래스의 제네릭 객체가 참조 가능
		 *   :   ? extends  -> 클래스 자기 자신 또는 sub클래스의 제네릭 객체가 참조가능
		 */ 
			
		Store <? extends Shape> sh = new Store<Shape>();	// ? extends 클래스를 사용했으므로
		sh = new Store<Rectangle>();						// sub클래스인 Rectangle이나 Triangle도 참조 가능
		// 물론 자기자신도 가능
		System.out.println(sh.getData().getName());
		
		Store <? super Rectangle> rect = new Store<Shape>();
//		sh.setData(new Rectangle());
	}
}