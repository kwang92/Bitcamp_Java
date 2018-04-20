package inner;

public class OuterClass {
	// 내부에 클래스를 포함하고 있는 클래스
	// 멤버변수 하나 선언, 내부클래스 선언, 내부클래스에서 멤버변수 접근
	private String name = "time is gold";
	private InnerClass in;
	public OuterClass() {
		in = new InnerClass();
		in.showScreen();
	}
	public InnerClass getIn() {
		return in;
	}
	
	
	public static class InnerClass{
		public InnerClass() {
			System.out.println("내부클래스 생성자 호출");
		}
		public void showScreen() {
			System.out.println("안녕");
		}
	}
	
}
