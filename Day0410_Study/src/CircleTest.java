
public class CircleTest {
	public static void main(String[] args) {
		Circle cir = new Circle(new Point(30,40),5);
		System.out.println(cir);
		
		cir.setRadius(7);
		System.out.println(cir);
		
		Circle cir2 = new Circle();
		
		System.out.println(cir2);
		
	}
}