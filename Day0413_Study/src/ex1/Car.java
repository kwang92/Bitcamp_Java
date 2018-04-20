package ex1;

public class Car{			// public 어디든 다됨
	protected int speed;	// protected 접근제한자는 패키지가 달라도 상속관계일 시 접근이 가능함
	private int mileage;	// package(default) 다되긴하는데 패키지 다르면 안됨
	private String color;	// private 걍 다 안됨 자기 자신범위에서만 가능
	private static int total_Car = 0;
	
	public Car() {
		total_Car++;
		this.speed = 100;
	}
	public void speedUp() {
		if(this.speed >= 150) {
			System.out.println("최대속도입니다.");
			return;
		}
		this.speed += 10;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int speed) {
		this.mileage += (speed / 60 )/ 60;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public static int getTotal() {
		return total_Car;
	}
	public void printNumOfCars() {
		System.out.println(total_Car+"대");
	}
	public String toString() {
		return String.format("[색상 : %s] [속도 : %d] [주행거리 : %d]\n", this.color,this.speed,this.mileage);
	}
}
