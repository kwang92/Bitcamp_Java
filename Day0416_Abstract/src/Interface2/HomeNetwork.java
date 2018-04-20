package Interface2;

public class HomeNetwork{
	public static void main(String[] args) {
		// 무선으로 조종할 수 있는 기능을 가진 가전 제품을 조종
		Electronic[] t = new Electronic[2];
		t[0] = new Tv();
		t[1] = new AirCondition();
		
		for(Electronic r : t) {
			r.turnOn();
			r.work();
		}	
	}
}