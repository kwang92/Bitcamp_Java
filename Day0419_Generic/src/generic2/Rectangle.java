package generic2;


public class Rectangle extends Shape {
	private int lineLength;
	
	public Rectangle() {
		this.name = "사각형";
	}
	public Rectangle(int lineLength) {
		this.lineLength = lineLength;
		this.name = "사각형";
		calArea();
	}
	public void draw() {
		System.out.println("사각형을 그립니다.");
	}
	public void calArea() {
		this.area = lineLength * lineLength;
	}
	public int getLineLength() {
		return lineLength;
	}
	public void setLineLength(int lineLength) {
		this.lineLength = lineLength;
	}
	@Override
	public String toString() {
		return "Rectangle [lineLength=" + lineLength + ", area=" + area + ", name=" + name + "]";
	}
	
	
}