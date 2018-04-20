
public class AnonymousTest3 {
	public static void main(String[] args) {
		Drawable dr = new Drawable() {
			public void draw() {
				System.out.println("그려");
			}
		};
		dr.draw();
	}
}
