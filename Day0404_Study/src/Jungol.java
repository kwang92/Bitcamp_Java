import java.util.Scanner;

public class Jungol {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		int before = -1, now = 1;
		int cm = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				now = 1;
			}else {
				now = 0;
			}
			
			if(before == now) {
				cm += 5;
			}else {
				cm += 10;
			}
			
			before = now;
		}
		System.out.println(cm);
	}
}