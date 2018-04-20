
public class Break_Ex {
	public static void main(String[] args) {
		/*
		 * break - continue
		 * break : 반복문 탈출 ,	continue : 해당 반복 순서의 문장을 실행하지 않고 다음반복으로 진행
		 */
/*
		for(int i = 1 ; i <= 10; i++) {
			if(i % 5 == 0)
				continue;
			System.out.print(i+" ");
		}
		
		// 다중 반복문에서의 break
	*/
		
		// ★★ 내장 for문에서 바깥에 있는 for을 break 하는 방법 --> 반복문에 tag를 달아준다.
		
		int cnt = 0;
		boolean isOut = false;
		
		loop1:	// 반복문 태그 작성	
		for(int i = 1; i <= 7; i++) {
			for(int j = 1; j <= 5; j++) {
				if(i == 3 && j == 3) {
					break loop1;	// loop1 즉, 바깥쪽 반복문 break
				}
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}