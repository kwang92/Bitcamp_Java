package d02;

public class RobotTest {
	public static void main(String[] args) {
		Robot[] robots = new Robot[3];
		robots[0] = new Transformer();
		robots[1] = new TaekwonV();
		robots[2] = new Gundam();
		
		for(Robot r : robots) {
			r.fight();
			System.out.println("============");
		}
	}
}
