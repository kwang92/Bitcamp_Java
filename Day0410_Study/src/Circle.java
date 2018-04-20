
public class Circle {
	private final double PI = 3.14;
	private Point center;
	private int radius;
	
	public Circle() {
		this.center = new Point();
	}
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	public Circle(int rdaius, int x, int y) {
		this.radius = radius;
		this.center.setX(x);
		this.center.setY(y);
	}
	public void setCenter(int x, int y) {
		this.center.setX(x);
		this.center.setY(y);
	}
	public Point getCenter() {
		return center;
	}
	public double getArea() {
		return radius * radius * PI;
		
	}
	public double getRound() {
		return 2 * radius * PI;
	}
	public int getRadius() {
		return this.radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public String toString() {
		return String.format("반지름은 %d, 넓이는 %.2f 중심좌표는 %d, %d\n"
				,this.radius,this.getArea(),this.center.getX(),this.center.getY());
	}
	
}