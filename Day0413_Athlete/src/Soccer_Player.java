import java.lang.reflect.Field;

public class Soccer_Player extends SportsPlayer {
	private String position;
	private char useLeg;
	private String nation;
	
	public Soccer_Player() {
		this.position = "미정";
		this.nation = "?";
		useLeg = '?';
	}
	public Soccer_Player(String name, int age) {
		this.name = name;
		this.age = age;
		useLeg = '?';
	}
	public Soccer_Player(String position, String nation, char useLeg) {
		this.position = position;
		this.nation = nation;
		this.useLeg = useLeg;
		useLeg = '?';
	}
	public void play() {
		System.out.println("축구경기를 시작합니다.");
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public char getUseLeg() {
		return useLeg;
	}
	public void setUseLeg(char useLeg) {
		this.useLeg = useLeg;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public Field[] getFields() {
		Field[] fi = this.getClass().getDeclaredFields();
		
		return fi;
	}
	@Override
	public String toString() {
		return String.format("[이름 : %s, 나이 : %d, 팀이름 : %s, 연봉 : %d, 포지션 : %s, 주족 : %c, 국적 : %s ]\n"
				, name, age, teamName, salary, position, useLeg, nation);
	}
}
