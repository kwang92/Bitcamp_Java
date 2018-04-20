package d02;

public class Gundam extends Robot{

	public Gundam() {
		this.name = "건담";
	}
	public void move() {
		System.out.println("날아다닌다");
	}
	public void attack(){
		System.out.println("총으로 공격");
	}
}
