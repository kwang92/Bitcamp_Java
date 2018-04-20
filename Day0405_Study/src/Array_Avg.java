import java.util.Scanner;

public class Array_Avg {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	// 사용자로부터 입력을 받을 Scanner 변수 생성
		final int ROW = 4, COL = 2;		// 가로 값 4, 세로 값 2 final 변수 선언
		int[][] arr = new int[4][2];	// 4 x 2 크기의 2차원 정수배열 생성
		
		for(int i = 0; i < ROW; i++) {	// 2차원 배열에 정수값을 사용자로부터 입력받는다.
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = input.nextInt();
			}
		}
	
		int sum_row = 0;	// 가로 값을 더해서 저장할 변수 선언
		int[] sum_col = new int[2];	// 세로 값을 더해서 저장할 정수배열 선언
		
		for(int i = 0; i < ROW; i++) {	
			sum_row = 0;	// 가로 값이 구해질 때 마다 0으로 초기화
			for(int j = 0; j < arr[i].length; j++) {
				sum_row += arr[i][j]; 	// 가로의 값들을 누적 합
				sum_col[j] += arr[i][j];	// 세로의 값들을 누적 합
			}
			System.out.print(sum_row/arr[i].length+" ");	// 가로의 값 출력
		}
		System.out.println();
		System.out.printf("%d %d\n",sum_col[0]/ROW,sum_col[1]/ROW);
		System.out.println((sum_col[0]+sum_col[1])/ (ROW * COL));
		
	}
}