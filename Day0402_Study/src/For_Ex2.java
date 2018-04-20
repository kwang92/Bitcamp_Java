import java.util.Scanner;

public class For_Ex2 {
	public static void main(String[] args) {
		// for문을 이용한 누적합 구하기
		Scanner input = new Scanner(System.in);
		int sum = 0, num;
		System.out.print("숫자 입력: ");
		num = input.nextInt(10);
		
		for(int i = 1; i <= num; i++ ) {
			sum += i;
		}
		System.out.println(num+"까지의 누적 값은 "+sum+"입니다.");
		
		input.close();
	}
}
