
public class Score {
	public static void main(String[] args) {
		
		int[][] classScore = {{100, 90, 88, 90},	// 각 반들의 점수를 2차원 정수형 배열에 저장
							{90, 77, 60},
							{100, 100, 50, 50, 40},
							{100, 99, 80, 90, 100, 0}};
		final int CLASS_NUMBER = classScore.length;	// 반의 수를 final 변수에 저장
		int[] sum = new int[CLASS_NUMBER];		// 반의 수만큼의 정수형 배열 생성
		double[] avg = new double[CLASS_NUMBER];	// 반우 수만큼의 실수형 배열 생성
		
		for(int i = 0; i < classScore.length; i++) {	// 반의 수만큼 반복문 반복
			for(int j = 0; j < classScore[i].length; j++) {	// 반의 학생 수 만큼 반복문 반복
				sum[i] += classScore[i][j];	// 학생 한명 한명의 점수를 sum 정수배열에 누적합
			}
			avg[i] = (double)sum[i] / classScore[i].length;	// 한 반의 총합이 구해지면 총합으로 반의 평균 계산
		}
		
		for(int i = 0; i < CLASS_NUMBER; i++) {	// 총 점과 평균 출력
			System.out.printf("%d반: 총점 %d점,  평균 %.1f점\n",i+1,sum[i],avg[i]);
		}
	}
}
 
