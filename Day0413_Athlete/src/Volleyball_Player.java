import java.lang.reflect.Field;

public class Volleyball_Player extends SportsPlayer{
	private String position;
	private double jumpAvg;
	
	public Volleyball_Player() {
		this.position = "미정";
	}
	public Volleyball_Player(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void play() {
		System.out.println("배구경기를 시작합니다.");
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getJumpAvg() {
		return jumpAvg;
	}
	public void setJumpAvg(double jumpAvg) {
		this.jumpAvg = jumpAvg;
	}
	public Field[] getFields() {
		Field[] fi = this.getClass().getDeclaredFields();
		
		return fi;
	}
	@Override
	public String toString() {
		return String.format("[이름 : %s, 나이 : %d, 팀이름 : %s, 연봉 : %d, 포지션 : %s, 점프높이 : %.2f]\n"
				, name, age, teamName, salary, position, jumpAvg);
	}
	
}
