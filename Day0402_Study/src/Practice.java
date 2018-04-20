import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		/*
		 * 	while - break 연습예제
		 * 		사용자에게 숫자(정수)를 입력받아서 계속해서 더합니다.
		 * 		-1을 입력받으면 그 전까지 더한 숫자의 총 합과 평균을 출력하는 프로그램 작성 
		 * 		( 단, 평균은 소수점 둘 째 자리에서 반올림하여 한자리만 표시 )
		 * ex) 5 10 6 7 -1
		 * 	  총합은 28 평균은 7.0입니다.
		 */
		
		Scanner input = new Scanner(System.in);	// 입력을 받기 위한 Scanner 객체 생성
		int cnt, sum;	// 평균을 구하기 위한 더한 횟수 cnt 와 총합을 저장할 변수 sum 선언
		int num;		// 입력받을 숫자를 저장하기 위한 변수선언
		double avg;		// 평균 값을 저장할 double 변수 선언
		cnt = sum = 0;	// 변수 0으로 초기화
		
		while(true) {	// -1을 받을 때 까지 반복하기 위하여 무한루프 실행
			num = input.nextInt();
			if(num == -1) {	// num 변수에 -1이 들어올 시 루프 break
				break;
			}
			sum += num;	// 받은 입력을 sum 변수에 누적 저장
			cnt++;		// 누적한 횟수 증가
		}
		
		avg = (double)sum / cnt;	// 총 합 sum 값을 입력받은 횟수 cnt로 double형 캐스팅 후 나눈 후 avg 저장
		System.out.printf("총합은 %d 평균은 %.1f입니다.\n",sum,avg);	// 결과 값 sum과 소수점 첫 째자리 avg 출력
		
		input.close();	// Scanner 객체 close
	}
}