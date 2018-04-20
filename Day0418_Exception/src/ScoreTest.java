
public class ScoreTest {
	public static void main(String[] args) {
		Score s = new Score();
		
		s.storeTotal(500);
		
		try {
			s.setTotal(10);
			s.setTotal(7);
		}catch(oddNumberException e) {
			System.out.println("홀수면 안됩니다.");
		}
		
		s.showTotal();
	}
}