import java.lang.reflect.Field;

public class PingPong_Player extends SportsPlayer{
	private String strongPoint;		// 선수의 강점 서브, 드라이브, 커브 등
	private String racket_Brand;	// 라켓 브랜드 ㅋ
	private String racket_Style;	// 라켓 스타일
	
	public PingPong_Player() {}
	public PingPong_Player(String strongPoint) {
		this.strongPoint = strongPoint;
	}
	public PingPong_Player(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void play() {
		System.out.println("탁구경기를 시작합니다");
	}
	public String getStrongPoint() {
		return strongPoint;
	}
	public void setStrongPoint(String strongPoint) {
		this.strongPoint = strongPoint;
	}
	public String getRacket_Brand() {
		return racket_Brand;
	}
	public void setRacket_Brand(String racket_Brand) {
		this.racket_Brand = racket_Brand;
	}
	public String getRacket_Style() {
		return racket_Style;
	}
	public void setRacket_Style(String racket_Style) {
		this.racket_Style = racket_Style;
	}
	public Field[] getFields() {
		Field[] fi = this.getClass().getDeclaredFields();
		
		return fi;
	}
	@Override
	public String toString() {
		return String.format("[이름 : %s, 나이 : %d, 팀이름 : %s, 연봉 : %d, 강점 : %s, 라켓스타일 : %s, 라켓브랜드 : %s ]\n"
				, name, age, teamName, salary, strongPoint, racket_Style, racket_Brand);
	}
	
	
	
}
