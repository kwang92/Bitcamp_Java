package Interface2;

public class AirCondition extends Electronic{
	public void turnOff() {
		System.out.println("에어컨을 끕니다.");
	}
	public void turnOn() {
		System.out.println("에어컨을 켭니다.");
	}
	
	public void work() {
		System.out.println("찬바람 쌩쌩");
	}
}