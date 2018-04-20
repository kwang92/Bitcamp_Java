
public class AnonymousTest2 {
	public static void main(String[] args) {
		Animal ani = new Animal() {
			public void move() {
				System.out.println("저벅저벅");
			}
		};
		ani.move();
		ani.name = "검은머리짐승";
		ani.numOfLegs = 2;
	}
}
