
public class Car {
	private String color;
	private int nowSpeed;
	private int mileage;
	private static int numCar = 0;
	public Car() {
		this.color = "red";
		nowSpeed = 0;
		mileage = 0;
		numCar++;
	}
	public Car(String color, int nowSpeed, int mileage) {
		this.color = color;
		this.nowSpeed = nowSpeed;
		this.mileage = mileage;
		numCar++;
	}
	public void speedUp() {
		this.nowSpeed += 5;
	}
	public void speedDown() {
		this.nowSpeed -= 5;
	}
	public void printCar() {
		System.out.println("color : "+color+","+
							" speed : "+nowSpeed+
							", mileage : "+mileage);
	}
	public static void printNumCar() {
		System.out.println("차 수량 : "+numCar);
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getNowSpeed() {
		return nowSpeed;
	}
	public void setNowSpeed(int nowSpeed) {
		if(nowSpeed >= 150) {
			this.nowSpeed = 150;
			return;
		}
		
		this.nowSpeed = nowSpeed;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
}