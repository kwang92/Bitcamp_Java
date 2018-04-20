import java.util.Scanner;

public class Array_Ex4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		final int nanu = 20091024;
		
		int num = input.nextInt();
		int gop = input.nextInt();
		
		if(num == 0 && gop == 0) {
			System.out.println(1);
			return;
		}
		System.out.println(zaegop(num,gop));
	
	}
	public static int zaegop(int num, int gop) {
		// % nanu;
		int su = 1;
		
		for(int i = gop; i >= 1; i--) {
			su = su * num;
		}
		su %= 20091024;
		return su;
	}
}