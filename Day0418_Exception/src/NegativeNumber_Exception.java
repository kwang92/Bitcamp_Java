// 사용자 정의 예외처리 Exception을 extends하고 super에 메시지를 보내준다.

public class NegativeNumber_Exception extends Exception{
	public NegativeNumber_Exception() {
		super("음수불가");	
	}
}