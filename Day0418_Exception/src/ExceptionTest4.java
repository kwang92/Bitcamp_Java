
public class ExceptionTest4 {
	public static void main(String[] args) {
		// 예외 처리 책임 전가시키기 : throws 예외
		Student s = new Student(300,0);
		
		try {
			s.showAvg();
		}catch(Exception e) {
			System.out.println("예외처리");
		}	
	}
}
