import java.util.Scanner;

public class Gugudan {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("출력할 구구단 입력: ");
		int num = input.nextInt();
		/*
		for(int i = 1; i < 10; i++) {
			System.out.println(num + " * " + i + " = " + (i*num));
		}
		*/
		
		for(int i = 9; i > 0; i--) {
			System.out.println(num + " * " + i + " = " + (i*num));
		}
		
		input.close();
		
	}
} 