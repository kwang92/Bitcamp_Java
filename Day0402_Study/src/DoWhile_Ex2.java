import java.util.Random;
import java.util.Scanner;

public class DoWhile_Ex2 {
	public static void main(String[] args) {
		// 사용자가 특정한 수를 맞추는게임
		Scanner input = new Scanner(System.in);
		Random ran = new Random();
		int guess, goal = ran.nextInt(100)+1;
		int cnt = 0;
		do {
			System.out.print("답을 예측해보세요: ");
			guess = input.nextInt();
			cnt++;
			if(guess > goal) {
				System.out.println("down!!!");
			}
			else if (guess < goal) {
				System.out.println("up!!!");
			}
		}while(guess != goal);
		
		System.out.println(cnt+"번만에 정답입니다!");
		input.close();
	}
}