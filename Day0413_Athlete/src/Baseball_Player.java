
public class Baseball_Player extends SportsPlayer{
	public String position;
	private double batting_Rate;
	private char useHand;

	public Baseball_Player() {
		useHand = '?';
		position = "미정";
	}

	public Baseball_Player(String name, int age) {
		this.name = name;
		this.age = age;
		useHand = '?';
	}
	public Baseball_Player(String position, double batting_RATE, char useHand) {
		this.position = position;
		this.batting_Rate = batting_RATE;
		this.useHand = useHand;
		useHand = '?';
	}
	public void play() {
		System.out.println("야구를 시작합니다.");
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getBatting_Rate() {
		return batting_Rate;
	}
	public void setBatting_Rate(double batting_Rate) {
		this.batting_Rate = batting_Rate;
	}
	public char getUseHand() {
		return useHand;
	}
	public void setUseHand(char useHand) {
		this.useHand = useHand;
	}


	@Override
	public String toString() {
		return String.format("[이름 : %s, 나이 : %d, 팀이름 : %s, 연봉 : %d, 포지션 : %s, 타율 : %.2f, 주손 : %c ]\n"
				, name, age, teamName, salary, position, batting_Rate, useHand);
	}


}
