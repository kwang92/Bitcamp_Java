package Interface2;

public class Tv extends Electronic{
	/* interface를 상속받았기 때문에
	 * abstract 메서드를 포함하고 있는것과 같다.
	 * 미완성인 메서드를 포함하고 있으면 클래스를 완성할 수 없다.
	 * 클래스 완성을 위해서는 2가지ㅏ가 있다. 1. abstract를 구현하거나, ㅏㅈ기 자신도 abstrace 이거나 
	 **/
	public void turnOff() {
		System.out.println("텔레비전을 끕니다.");
	}
	public void turnOn() {
		System.out.println("텔레비전을 킵니다.");
	}
	
	public void work() {
		System.out.println("화면을 보여줍니다.");
	}
}
