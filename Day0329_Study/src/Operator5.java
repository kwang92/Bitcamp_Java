
import java.util.Scanner;

public class Operator5 {
	public static void main(String[] args) {
		// 조건 삼항연산자
		
		/*
		// grade : 학년, 4학년 이상 ( 4, 5, 6 )이면 용돈 500, 이하면 100원
		int money, grade;
		
		grade = 3;
		money = (grade > 3)?500:100;
		System.out.println(grade+"학년이므로 용돈은 "+money+"원 입니다.");
		*/
		
		/*
		// 사용자에게 숫자 2개를 입력받아서 어떤 숫자가 큰지?
		Scanner input = new Scanner(System.in);
		int num1, num2, max;
		System.out.print("첫 번째 숫자입력: ");
		num1 = input.nextInt();
		System.out.print("두 번째 숫자입력: ");
		num2 = input.nextInt();
		max = num1>num2?num1:num2;
		System.out.println("더 큰 값은 "+max+"입니다.");
		*/
		
		// 3개 입력받아서 중간 숫자 찾기
		Scanner input = new Scanner(System.in);
		int num1, num2, num3, mid;
		System.out.print("첫 번째 숫자입력: ");
		num1 = input.nextInt();
		System.out.print("두 번째 숫자입력: ");
		num2 = input.nextInt();
		System.out.print("세 번째 숫자입력: ");
		num3 = input.nextInt();
		/*
		mid = (num1 > num2 && num1 < num3) || (num1 > num3 && num1 < num2)?num1:
			 	(num2 > num1 && num2 < num3) || (num2 < num1 && num2 > num3)?num2:num3;
		*/
		mid = (num1>num2)?
				((num1>num3)?((num2>num3)?num2:num3):num1):
				((num2>num3)?((num1>num3)?num1:num3):num2);

		System.out.println("중간값은 "+mid+"입니다.");
		input.close();
		
	}
}