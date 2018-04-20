import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
	public static void main(String[] args) {
		ArrayList<Student> stuList = new ArrayList<Student>();
		Scanner in = new Scanner(System.in);
		
		System.out.print("입력할 정보의 수 : ");
		int num = in.nextInt();
		
		for(int i = 0; i < num; i++) {
			System.out.println("총 학생 수 : "+Student.getTotalStu());
			String name;
			int grade, kor, eng, math;
			
			in.nextLine();
			System.out.print("이름 입력 : ");
			name = in.nextLine();
			System.out.print("학년 입력 : ");
			grade = in.nextInt();
			System.out.print("국어점수 입력 : ");
			kor = in.nextInt();
			System.out.print("영어점수 입력 : ");
			eng = in.nextInt();
			System.out.print("수학점수 입력 : ");
			math = in.nextInt();

			stuList.add(new Student(name, grade, new Score(kor,eng,math)));
		}
		
		for(Student s : stuList) {
			System.out.println(s);
		}
		in.close();
	}
}
