
public class SportsCar extends Car{
	private boolean isTurbo;
	
	public SportsCar() {
		super();
		isTurbo = false;
	}
	
	public void speedUp() {
		if(this.speed >= 300) {
			System.out.println("최대속도입니다.");
			return;
		}
		if(isTurbo) {
			this.speed += 60;
			return;
		}
		this.speed += 20;
	}
	public void turboOn() {
		isTurbo = true;
	}
	public void turboOff() {
		isTurbo = false;
		speed = speed - 60;
	}
}