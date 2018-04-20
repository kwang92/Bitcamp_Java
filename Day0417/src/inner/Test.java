package inner;

public class Test {
	public static void main(String[] args) {
		OuterClass out = new OuterClass();
		out.getIn().showScreen();

		// 내부 클래스가 일반 class 일 경우 
		OuterClass.InnerClass a;
		a = new OuterClass.InnerClass();
		
		
		// 내부 클래스가 static으로 선언 되있을 때, 이 경우엔 outer클래스의 인스턴스 변수에 접근할 수 없다.
		OuterClass.InnerClass b = new OuterClass.InnerClass();
		
		a.showScreen();
		b.showScreen();
	}
}