import java.util.Scanner;

public class Sosae {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[][] arr1 = new int[num][2];
		int[][] max = new int[num][2];
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < 2; j++) {
				arr1[i][j] = in.nextInt();
			}
		}
		// input 완료
		
		
	}
}
