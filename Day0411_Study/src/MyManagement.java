import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyManagement {
	private ArrayList<Student> stuList;
	private static int totalStudent = 0;
	private final int ANY = 9999;
	public MyManagement() {	
		stuList = new ArrayList<Student>();
	}

	public void start() {
		inputMenu();
	}
	public void inputMenu() {
		Scanner in = new Scanner(System.in);
		inputLoop:while(true) {
			showMenu(1,ANY);

			System.out.print("번호선택 : ");
			int num = in.nextInt();

			switch(num) {
			case 1:
				System.out.println("정보보기 선택");
				displayStuList();
				break;
			case 2:
				System.out.println("정보수정 선택");
				modify();
				break;
			case 3:
				System.out.println("정보삭제 선택");
				remove();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				break inputLoop;
			default:
				System.out.println("1~4범위 안의 번호를 선택해주세요.");
			}
			System.out.println();
		}
	}
	public void remove() {
		displayStuList();

		Scanner in = new Scanner(System.in);
		System.out.print("삭제할 학생 번호 입력 : ");
		int num = in.nextInt();
		stuList.remove(num-1);
	}
	public void modify() {

		int num;
		do {
			showMenu(2,ANY);

			Scanner in = new Scanner(System.in);
			num = in.nextInt();
		}while(num != 1 && num != 2);
		switch(num) {
		case 1:
			addStudent();
			break;
		case 2:
			displayStuList();
			showMenu(3,choiceStu());
			break;
		}
	}
	public void modifyStudent(int num, int index) {
		Scanner in = new Scanner(System.in);
		try {
			switch(num) {
			case 1:
				System.out.print("현재이름 : "+stuList.get(index).getName()+"    수정할 이름 입력 : ");
				String name = in.nextLine();
				stuList.get(index).setName(name);
				break;
			case 2:
				System.out.print("현재학년 : "+stuList.get(index).getGrade()+"    수정할 학년 입력 : ");
				int grade = in.nextInt();
				stuList.get(index).setGrade(grade);
				break;
			case 3:
				System.out.print("국어점수 : "+stuList.get(index).getScore().getkor()+"    수정할 점수 입력 : ");
				int kor = in.nextInt();
				stuList.get(index).setKor(kor);
				break;
			case 4:
				System.out.print("영어점수 : "+stuList.get(index).getScore().getEng()+"    수정할 점수 입력 : ");
				int eng = in.nextInt();
				stuList.get(index).setEng(eng);
				break;
			case 5:
				System.out.print("수학점수 : "+stuList.get(index).getScore().getMath()+"    수정할 점수 입력 : ");
				int math = in.nextInt();
				stuList.get(index).setMath(math);
				break;
			}
		}catch(InputMismatchException e) {
			System.out.println("점수는 숫자를 입력하세요.");
			return;
		}
		System.out.println("수정완료");
	}
	public void showMenu(int con, int choice) {
		switch(con) {
		case 1:
			System.out.println("[ 1.정보보기  2.정보수정  3.정보삭제  4.종료 ]");
			break;
		case 2:
			System.out.println("[ 1.학생추가  2.학생정보 수정 ]");
			break;
		case 3:
			int num;
			do{
				num = 0;
				System.out.println("[ 1.이름  2.학년  3.국어점수  4.영어점수  5.수학점수  6.수정종료 ]");
				Scanner in = new Scanner(System.in);
				System.out.print("수정할 번호를 입력하세요 : ");
				num = in.nextInt();
				modifyStudent(num,choice-1);

			}while(num != 6);
			break;

		}
	}

	public int choice_Modify_Menu() {
		Scanner in = new Scanner(System.in);

		return 1;
	}
	public int choiceStu() {
		Scanner in = new Scanner(System.in);
		System.out.print("수정할 학생번호 입력: ");
		int num = in.nextInt();
		return num;
	}
	public void addStudent() {
		Student stu = new Student();

		stuList.add(stu);
		totalStudent++;
	}
	public void delStudent(int index) {
		stuList.remove(index);
		totalStudent--;
	}
	public void displayStuList() {
		if(stuList.size() == 0) {
			System.out.println("학생목록이 비어있습니다.");
			return;
		}
		for(int i = 1; i <= stuList.size(); i++)
			System.out.println("["+i+"] "+stuList.get(i-1));
	}
}
