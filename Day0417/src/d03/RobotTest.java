package d03;


public class RobotTest {
	public static void main(String[] args) {
		// 메서드 내에 작성된 코드 중복없애기
		Robot[] robots = new Robot[3];
		Attackable gunAttack = new GunAttack();
		Moveable flyMove = new FlyMove();
		Attackable punchAttack = new PunchAttack();
		Moveable runMove = new RunMove();
		
		
		robots[0] = new Transformer(gunAttack,runMove);
		robots[1] = new TaekwonV(punchAttack, flyMove);
		robots[2] = new Gundam(gunAttack, flyMove);
		
		for(Robot r : robots) {
			r.fight();
			System.out.println("============");
		}
	}
}
