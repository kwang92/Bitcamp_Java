
public class Array_Ex {
	public static void main(String[] args) {
		/* 배열 ( Array )에 대해서 공부
		 * 배열은 같은 데이터타입의 변수의 모음
		 */
		
		// 정수형 데이터 3개를 저장할 수 있는 배열 생성하기
		int[] numbers;	// 정수배열의 주소값을 저장할 수 있는 참조변수
		
		numbers = new int[3];	// 배열 만들기 & 주소값 참조변수에 넣기
		numbers[0] = 1;
		numbers[1] = 3;
		numbers[2] = 5;
		System.out.println(numbers[3]);
	}	
}