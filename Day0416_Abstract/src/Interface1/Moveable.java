package Interface1;

public interface Moveable {	// interface는 추상메소드들로만 이루어져 있다.
	// abstract를 따로 안써줘도 interface 내부 메소드는 자동으로 abstract 취급
	// interface 내부 메소드의 몸체내용을 작성하면 error
	public void move();		// 객체 생성이 안됨, 하지만 타입으로는 사용이 가능하다.
}
