package list;
import java.util.Scanner;

public class MyManagement2{
	private Scanner input;
	private MyList <Student> stu;
	
	public MyManagement2() {		// MyManagement 클래스 생성자 
		input = new Scanner(System.in);
		stu = new MyList<Student>();
	}
	public void start() {	// 프로그램 start 메소드 ( 최초 Menu 선택 )
		boolean boot = true;	// 프로그램 자체 무한루프를 종료/작동 시키는 boolean
		int choice;				// 메뉴선택 숫자

		do {
			viewMenu();	// 1. 정보보기, 2. 정보추가, 3. 정보삭제, 4. 검색   5. 종료
			System.out.print(": ");
			choice = input.nextInt();

			switch(choice) {
			case 1:
				showStudents();
				break;
			case 2:	// 2. 정보수정 선택시  학생추가, 학생정보 수정으로 나뉜다. 
				this.stuAdd();
				break;
			case 3:	// 정보 삭제
				this.stuRemove();
				break;
			case 4:	// 학생 이름정보 검색
				this.search();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				boot = false;
				break;
			default:
				System.out.println("범위 내의 숫자를 입력하세요");
			}

		}while(boot);
	}
	public void viewMenu() {	// 선택 Menu 출력 메소드	
		System.out.println("[1]정보보기   [2]학생추가   [3]학생삭제   [4]검색   [5]종료 ");
	}
	public void search() {	// 이름 탐색 메소드
		Scanner input = new Scanner(System.in);
		System.out.print("검색할 학생 이름 : ");
		String name = input.next();
		System.out.println(name+"을 검색합니다.");
		System.out.println(stu.get(searchByName(name)));
	}
	public void stuRemove() {	// 노드 삭제 메소드
		Scanner input = new Scanner(System.in);

		System.out.print("삭제할 이름을 입력하세요 : ");
		String data = input.nextLine();
		
		stu.remove(searchByName(data));	
	}
	public void stuAdd() {	// 학생 추가 메소드, 배열크기가 꽉차면 원래크기 *2 크기 만큼의 배열로 바꿔준다.
		Scanner input = new Scanner(System.in);
		System.out.println("학생을 추가합니다.");
		
		System.out.print("학생이름 입력 : ");
		String name = input.nextLine();
		System.out.print("학년 입력 : ");
		int grade = input.nextInt();
		Student s = new Student(name,grade);
		
		System.out.print("국어 점수 입력: ");
		s.setKor(input.nextInt());
		System.out.print("영어 점수 입력: ");
		s.setEng(input.nextInt());
		System.out.print("수학 점수 입력: ");
		s.setMath(input.nextInt());
		
		stu.add(s);	// Student_List의 add 메소드 호출
	}
	public void showStudents() {	// 학생목록 출력 메소드
		for(int i = 0; i < stu.size(); i++) {
			System.out.println("["+(i+1)+"]"+stu.get(i));	//// Student_List의 getStu 메소드 호출
			System.out.println("=================================================================");
		}
		System.out.println();
	}
	public int searchByName(String n) {	// 학생 검색
		for(int i = 0; i < stu.size(); i++) {
			if(stu.get(i).getName().equals(n)) {
				return i;
			}
		}
		return -1;
	}

}