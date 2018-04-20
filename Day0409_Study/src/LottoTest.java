
public class LottoTest {
	public static void main(String[] args) {
		// 1 ~ 45 사이의 중복되지 않는 6개의 수를 생성하는 Lotto 클래스 생성
		// 
		Lotto lo = new Lotto();
		lo.makelottoNumbers();
		lo.printLotto();
		
		lo.sortLotto();
		lo.printLotto();
		
		System.out.println();
		
		int[] arr = new int[6];
		Lotto lo2 = new Lotto(arr);
		lo2.makelottoNumbers();
		lo2.printLotto();
	
		lo2.sortLotto();
		lo2.printLotto();
	
	}	// ctrl + f  
}		//	options -> Case sensitive (대소문자 구분)