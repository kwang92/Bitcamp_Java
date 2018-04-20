package ex3;

public class Triangle extends Shape{
	private int underLength;
	private int height;
	
	public Triangle() {
		this.name = "삼각형";
	}
	public Triangle(int underLength, int height) {
		this.underLength = underLength;
		this.height = height;
		this.name = "삼각형";
		calArea();
	}
	public void draw() {
		System.out.println("삼각형을 그립니다.");
	}
	public void calArea() {
		this.area = (double)( underLength * height )/ 2;
	}
	public int getUnderLength() {
		return underLength;
	}
	public void setUnderLength(int underLength) {
		this.underLength = underLength;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Triangle [underLength=" + underLength + ", height=" + height + ", area=" + area + ", name=" + name
				+ "]";
	}
	
	
	
	
}
