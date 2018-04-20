
public class ExceptionTest5 {
	public static void main(String[] args) {
		Student s = new Student(300,0);
		
		try {
			s.showAvg();	
		}catch(ArithmeticException e){
			System.out.println("0으로 못나눔");
		}catch(Exception e) {
			System.out.println("예외발생");
		}finally {
			System.out.println("try 정상종료");
		}
	}
}