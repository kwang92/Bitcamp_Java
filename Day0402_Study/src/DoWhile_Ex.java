import java.util.Scanner;

public class DoWhile_Ex {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num;
		do {
			System.out.print("0~5000 사이의 숫자를 입력해주세요: ");
			num = in.nextInt();
		}while(num < 0 || num > 5000);
		
		in.close();
	}
}
