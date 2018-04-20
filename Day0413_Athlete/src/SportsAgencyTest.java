import java.util.InputMismatchException;

public class SportsAgencyTest {
	public static void main(String[] args) throws Exception {
		SportsAgency sa = new SportsAgency();
		try {
			sa.start();
		}catch(InputMismatchException e) {
			System.out.println("올바른 값을 입력해주세요");
		}
	}
}
