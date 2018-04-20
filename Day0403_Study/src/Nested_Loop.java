import java.util.Scanner;

public class Nested_Loop {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int start, end;
		System.out.print("시작할 단 입력: ");
		start = input.nextInt();
		System.out.print("끝 단 입력: ");
		end = input.nextInt();
		// 3 x 3 구구단 ( 2단~ 9단 )
		/*
		for(int i = 0; i < 3; i++) {
			for(int j = 1; j < 10; j++) {
				for(int k = (3*i)+2; k < 3*i+5; k++) {
					if(k == 10)
						continue;
					System.out.print(k+" * "+j+" = "+k*j+"\t");
				}
				System.out.println();
			}
			System.out.println();
		}*/
		
		// 원하는 단 범위 입력받은 세로 구구단
		for(int i = 1; i <10; i++) {
			for(int j = start; j <=end; j++) {
				System.out.print(j+" * "+i+" = "+(i*j)+"\t");
			}
			System.out.println();
		}
		
		/*
		// 가로 구구단
		for(int i = 2; i <10; i++) {
			for(int j = 1; j <10; j++) {
				System.out.print(i+" * "+j+" = "+(i*j)+"\t");
			}
			System.out.println();
		}*/
	}
}