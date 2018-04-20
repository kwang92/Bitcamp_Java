
public class Array_Ex3 {
	public static void main(String[] args) {	
		// 배열의 객체를 생성하면 각 원소들은 숫자데이터라면 0의 값을 기본으로 가진다.
		// 참조형 변수의 배열을 생성하면 초기 값은 null로 초기화
		
		
		int[] c = {1,3,5};	// 초기값이 각각 1, 3, 5인 크기 3인 정수형 배열 생성. 단, 변수 선언시에만 사용할 수 있음
//		System.out.println(c[2]+" 크기->"+c.length);
		int[] arr = {};	// 크기 0인 배열을 만들어서 참조변수에 참조
		// 많이 쓰이지는 않지만 nullPointer 예외는 발생시키지 않음
	
		for(int i = 0 ; i < c.length; i++) {
			System.out.println(c[i]);
		}
		
		// 위의 for문과 아래의 for-each문은 기능이 동일
		
		for(int i : c) {
			System.out.println(i);
		}
	}
}
