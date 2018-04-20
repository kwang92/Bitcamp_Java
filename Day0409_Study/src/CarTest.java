public class CarTest{
	public static void main(String[] args) {
		Car myCar = new Car();
		System.out.println();
		myCar.color = "빨강";
		myCar.speed = 180;
		myCar.mileage = 2000;
		myCar.printCar();
		
		System.out.println();
		
		Car yourCar = new Car();
		yourCar.color = "검정";
		yourCar.speed = 150;
		yourCar.mileage = 250000;
		yourCar.printCar();
	}
}
class Car{
	String color;
	int speed;
	int mileage;
	static int car_num = 0;
	
	public Car() {
		car_num++;
	}
	public Car(String color) {
		this.color = color;
	}
	public void start() {
		System.out.println("시동을 걸고 출발합니다.");
	}
	public void stop() {
		System.out.println("시동을 끄고 멈춥니다.");
	}
	public void printCar() {
		System.out.println("색깔은 "+ color);
		System.out.println("최고속도는 "+ speed);
		System.out.println("주행거리는 "+ mileage);
	}
	public static int nowCar() {
		return car_num;
	}
}