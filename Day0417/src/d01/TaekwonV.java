package d01;

public class TaekwonV {
	private String name;
	public TaekwonV() {
		this.name = "태권브이";
	}
	public void fight() {
		System.out.println(name+" 전투시작");
		punchAttack();
		flyMove();
		punchAttack();
		System.out.println(name+" 전투종료");
	}
	public void punchAttack() {
		System.out.println("주먹으로 공격!!");
	}
	public void flyMove() {
		System.out.println("날아서 이동");
	}
}