
public class CarTest {
	public static void main(String[] args) {
		SportsCar sc = new SportsCar();
		
		sc.setSpeed(50);
		sc.turboOn();

		
		System.out.println(SportsCar.getTotal());
	}
}