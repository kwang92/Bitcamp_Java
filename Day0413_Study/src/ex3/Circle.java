package ex3;

public class Circle extends Shape {
	private final double PI = 3.14;
	private int radius;
	
	public Circle() {
		this.name = "원";
	}
	public Circle(int radius) {
		this.radius = radius;
		this.name = "원";
		calArea();
	}
	public void draw() {
		System.out.println("원을 그립니다.");
	}
	public void calArea() {
		this.area = (double)radius * radius * PI;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", area=" + area + ", name=" + name + "]";
	}
	
	
}
