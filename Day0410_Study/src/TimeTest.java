
public class TimeTest {
	public static void main(String[] args) {
		Time tm = new Time(11, 9, 32);
		tm.showTime();
		
		System.out.println();
		tm.setTime(26, 1, 99);
		System.out.println();
		tm.showTime();
		
		tm.setTime(24, 1, 2);
		
		System.out.println();
		System.out.println(tm.timeString());
	}
}
// 객체의 메소드로 toString을 오버라이딩 해주면
// 객체의 이름만으로 원하는 형식의 string을 출력할 수 있다.
// 위에 소스 기준으로 toString을 Time클래스에서 오버라이딩해주고
// System.out.println(tm); 만해주면 지정한 string이 반환됨