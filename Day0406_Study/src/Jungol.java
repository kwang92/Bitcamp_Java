import java.util.Scanner;

public class Jungol {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tCase;
		
		do {
			tCase = input.nextInt();
			int size = input.nextInt();
			String[] str = new String[size];
			
			input.nextLine();
			for(int i = 0; i < size; i++)
				str[i] = input.nextLine();
			
			
			
			tCase--;
		}while(tCase != 0);
	}
}