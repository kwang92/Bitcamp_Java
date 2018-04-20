import java.lang.reflect.Field;

public class Basketball_Player extends SportsPlayer {
	private String position;
	private double freeDraw_Rate;
	private int height;
	
	public Basketball_Player() {
		position = "미정";
	}
	public Basketball_Player(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Basketball_Player(String position, double freeDraw_Rate, int height) {
		this.position = position;
		this.freeDraw_Rate = freeDraw_Rate;
		this.height = height;
	}
	public void play() {
		System.out.println("농구 경기를 시작합니다.");
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getFreeDraw_Rate() {
		return freeDraw_Rate;
	}
	public void setFreeDraw_Rate(double freeDraw_Rate) {
		this.freeDraw_Rate = freeDraw_Rate;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void displayOption() {
		System.out.println("[1]이름  [2]나이  [3]팀명  [4]포지션  [5]자유투 성공률  [6]키  [7]연봉  [8]수상경력 추가\n");
	}
	public Field[] getFields() {
		Field[] fi = this.getClass().getDeclaredFields();
		
		return fi;
	}
	@Override
	public String toString() {
		return String.format("[이름 : %s, 나이 : %d, 팀이름 : %s, 연봉 : %d, 포지션 : %s, 자유투 성공률 : %.2f, 키 : %d ]\n"
				, name, age, teamName, salary, position, freeDraw_Rate, height);
	}
}