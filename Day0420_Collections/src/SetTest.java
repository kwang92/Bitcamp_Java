import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	public static void main(String[] args) {
		// Set - 중복을 허용하지 않는 자료구조 ( Collection의 인터페이스 )
		// Set의 구현 클래스 = HashSet ( Data를 가져 올 때 자동으로 정렬해서 가지고옴 )
		HashSet<String> set1 = new HashSet<String>();
		HashSet<String> set2 = new HashSet<String>();
		
		set1.add("D");
		set1.add("C");
		set1.add("A");
		set1.add("B");
		if(!set1.add("B")) {	// Hash의 set메소드는 boolean을 return, 중복이면 false 성공적으로 들어가면 true
			System.out.println("데이터 중복입니다.");
		}
		
		Iterator<String> it = set1.iterator();	// Iterator를 이용해서 HashSet의 데이터를 꺼내는 방법
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		
	}
}
