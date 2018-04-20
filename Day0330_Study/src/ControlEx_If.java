import java.util.Scanner;

public class ControlEx_If {
	public static void main(String[] args) {
		// if-else를 이용한 학점계산하기
		// 점수를 입력받아서 학점부여  점수 >= 90 - 'A', 점수 >= 80 - 'B'
		Scanner input = new Scanner(System.in);
		System.out.print("점수 입력: ");
		int score = input.nextInt();
		char grade;
		
		if( score >= 90 ){
			grade = 'A';
		}
		else if( score >= 80 ) {
			grade = 'B';
		}
		else if( score >= 70 ){
			grade = 'C';
		}
		else if( score >= 60 ){
			grade = 'D';
		}
		else{
			grade = 'E';
		}
		System.out.println(score+"점 이므로 등급은 '"+grade+"'입니다.");
		input.close();
	}
}