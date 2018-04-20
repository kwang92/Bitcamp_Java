import java.util.Scanner;

public class Array_Ex2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] score = new int[10];
		
		for(int i = 0; i < score.length; i++) {
			System.out.print((i+1)+"번째 학생점수 입력: ");
			score[i] = input.nextInt();
		}
		
		System.out.println("입력된 점수는");
		for(int i = 0; i < score.length; i++) {
			System.out.print(score[i]+" ");
		}
		System.out.println("("+score.length+"개)");		
	}
}
