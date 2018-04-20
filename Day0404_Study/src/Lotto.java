import java.util.Random;

public class Lotto {
	public static void main(String[] args) {
		/*
		 *	1 ~ 45까지의 정수 중에 중복되지않는 정수 6개를 생성  
		 *  크기 6인 정수형 배열에 수를 저장하여 출력 
		 */
		Random ran = new Random();	// 랜덤변수를 만들 Random 객체 ran 생성
		int[] arr = new int[6];	// 난수를 저장할 int배열 6개 생성
		int cnt = 0;	// 난수를 몇번 만들었는지 count할 변수 생성
		
		arr[0] = ran.nextInt(45)+1;
		for(int i = 1; i < 6; i++) {	// 6개의 난수를 생성할 반복문
			arr[i] = ran.nextInt(45)+1;	// 난수 생성, count 증가
			cnt++;
			for(int j = 0; j <= i-1; j++) {	// 첫번 째 생성 된 난수부터 현재 생성한 난수 전까지 중복 검사
				
				if(arr[j] == arr[i]) {	// 중복이 있으면 i 인덱스 1 감소 후 중복검사 반복문 break
					i--;	 
					break;
				}
			}
		}
		System.out.println("생성횟수: "+cnt);
		for(int i = 0; i < 6; i++) {	// 난수 저장한 배열 출력
			System.out.println(arr[i]);
		}
	}
}