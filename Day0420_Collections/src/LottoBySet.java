import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class LottoBySet {
	private Set<Integer> lottoNumbers;
	private Random ran;
	public LottoBySet() {
		lottoNumbers = new HashSet<Integer>();
	}
	public void makelottoNumbers() {
		Random ran = new Random();
		for(int i = 0; i < 6; i++) {
			if(!lottoNumbers.add(ran.nextInt(45)+1)) {
				i--;
			}
		}
	}
	public void printLotto() {
		Iterator it = lottoNumbers.iterator();	// Iterator 객체에 set의 iterator를 반환시킨다.
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
	}
}
