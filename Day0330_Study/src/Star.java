import java.util.Scanner;

public class Star {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int cnt = 1;
		char cnt2 = 'A';
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n-i; j++) {
				System.out.print(cnt++);
			}
			for(int j = 0; j < i+1; j++) {
				System.out.print(cnt2++);
			}
			System.out.println();
		}
	}
}
