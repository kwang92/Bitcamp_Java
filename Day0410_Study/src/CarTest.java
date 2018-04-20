
public class CarTest {
	public static void main(String[] args) {
		Car num1 = new Car();
		num1.printCar();
		num1.speedUp();
		num1.speedUp();
		num1.printCar();
		
		System.out.println();
		
		Car num2 = new Car("black",80,5000);
		num2.printCar();
		num2.speedDown();
		num2.printCar();
		
		Car.printNumCar();
		num2.setColor("White");
		num2.setNowSpeed(180);
		System.out.println("속도는 "+num2.getNowSpeed());
	}
}