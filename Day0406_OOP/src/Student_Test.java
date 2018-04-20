import java.util.Scanner;

public class Student_Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Student[] stu = new Student[2];
		int k, m, e;
		for(int i = 0 ; i < 2; i++) {
			stu[i] = new Student();
			
			System.out.print("이름을 입력 : ");
			stu[i].setName( input.next() );
	
			System.out.print("국어점수 입력 : ");
			k = input.nextInt();
			stu[i].setKorea(k);
	
			System.out.print("수학점수 입력 : ");
			m = input.nextInt();
			stu[i].setMath(m);
			
			System.out.print("영어점수 입력 : ");
			e = input.nextInt();
			stu[i].setEng(e);
			
			input.nextLine();
		}
		
		for(int i = 0; i < 2; i++) {
			stu[i].display();
		}
	}
}
