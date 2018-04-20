package Interface3;

public class DrawTest {
	public static void main(String[] args) {	
		Drawable[] d = new Drawable[3];
		d[0] = new Rectangle();
		d[1] = new Triangle();
		d[2] = new Circle();
		
		for(Drawable a : d) {
			a.draw();
		}	
	}
}