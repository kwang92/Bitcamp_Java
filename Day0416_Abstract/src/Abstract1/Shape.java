package Abstract1;

public abstract class Shape {
	protected double area;
	protected int numOfLines;
	protected String name;
	
	public Shape() {}
	public Shape(int numOfLines, String name) {
		this.numOfLines = numOfLines;
		this.name = name;
	}
	public abstract double calArea();
	public abstract void draw(); 
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public int getNumOfLines() {
		return numOfLines;
	}
	public void setNumOfLines(int numOfLines) {
		this.numOfLines = numOfLines;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Shape [area=" + area + ", numOfLines=" + numOfLines + ", name=" + name + "]";
	}
	
	
}
