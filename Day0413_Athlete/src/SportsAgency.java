import java.lang.reflect.Field;
import java.util.Scanner;

public class SportsAgency {
	private SportsPlayer[] players;
	private Scanner input;
	private boolean boot;
	private int data;

	public SportsAgency() {		// MyManagement 클래스 생성자 
		players = new SportsPlayer[0];	// 최초 Student 배열 크기 50 설정
		input = new Scanner(System.in);
		data = 0;
	}
	public void start() throws Exception{	// 프로그램 start 메소드 ( 최초 Menu 선택 )
		boot = true;	// 프로그램 자체 무한루프를 종료/작동 시키는 boolean
		int choice;				// 메뉴선택 숫자

		while(true) {
			if(!boot) {	// boot 값이 false가 되면 !을 만나 while루프 break
				break;
			}
			viewMenu();	// 첫 화면인 menu메서드 호출
			System.out.print("Input Number : ");
			choice = input.nextInt();	
			selectMenu(choice);	// 첫 번째 메뉴 선택
		}
	}
	public void viewMenu() {	// 초기 기본메뉴 출력
		System.out.println("\n================================");
		System.out.println("[1]선수목록  [2]정보수정  [3]선수검색  [4]종료");
		System.out.println("================================\n");
	}
	public void selectMenu(int choice) {	// 선택한 메뉴 분류 후 각 메서드 호출
		switch(choice) {
		case 1:
			showPlayers();
			break;
		case 2:
			modify();
			break;
		case 3:
			displayByName();
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			boot = false;
			break;
		default:
			System.out.println("1 ~ 4사이의 숫자를 입력하세요!");
		}
	}
	public void showPlayers() {	// 선수목록 선택 시 호출 메서드
		if(data == 0) {	// 총 저장된 배열의 개 수가 0이면 출력 후 메서드 종료
			System.out.println("선수가 비어있습니다!\n");
			return;
		}
		int num;	// 분야 별 선수 출력 혹은 전체 선수 출력가능하게 선택
		System.out.println("\n==========================================");
		System.out.println("[1]야구선수  [2]축구선수  [3]배구선수  [4]탁구선수  [5]농구선수  [6]전체목록");
		System.out.println("==========================================\n");
		System.out.print("Input number : ");
		num = input.nextInt();
		
		switch(num) {	// 분야별로 출력해줄 switch문
		case 1:
			for(int i = 0; i < players.length; i++) {
				if(players[i] instanceof Baseball_Player)
					System.out.println(players[i]);		
			}
			break;
		case 2:
			for(int i = 0; i < players.length; i++) {
				if(players[i] instanceof Soccer_Player)
					System.out.println(players[i]);		
			}
			break;
		case 3:
			for(int i = 0; i < players.length; i++) {
				if(players[i] instanceof Volleyball_Player)
					System.out.println(players[i]);		
			}
			break;
		case 4:
			for(int i = 0; i < players.length; i++) {
				if(players[i] instanceof PingPong_Player)
					System.out.println(players[i]);		
			}
			break;
		case 5:
			for(int i = 0; i < players.length; i++) {
				if(players[i] instanceof Basketball_Player)
					System.out.println(players[i]);		
			}
			break;
		case 6:
			for(int i = 0; i < players.length; i++) {
				System.out.println(players[i]);
			}
		default:
			System.out.println("범위내의 값을 입력해주세요.");
		}
	}
	public void modify() {	// 정보수정 메서드
		int num;
		System.out.println("\n===========================");
		System.out.println("[1]선수추가  [2]선수삭제  [3]정보수정");
		System.out.println("===========================\n");
		System.out.print("Input Number : ");
		num = input.nextInt();	

		switch(num) {
		case 1:
			addPlayer();
			break;
		case 2:
			removePlayer();
			break;
		case 3:
			modifyInfo();
			break;
		default:
			System.out.println("범위 내의 숫자를 입력하세요!");
		}
	}
	public void addPlayer() {	// 선수추가 시 어느 종목의 선수를 추가할 것인지 미리 input으로 받는다.
		String name;
		int age;
		int num;
		System.out.println("\n==========================================");
		System.out.println("[1]야구선수  [2]축구선수  [3]배구선수  [4]탁구선수  [5]농구선수");
		System.out.println("==========================================\n");
		System.out.println("추가할 선수의 종목 입력 : ");
		num = input.nextInt();
		System.out.print("이름을 입력하세요 : ");
		name = input.next();
		System.out.print("나이를 입력하세요 : ");
		age = input.nextInt();

		addArrSize();	// 이름, 나이같은 기본정보만 입력받은 후 배열사이즈를 늘려준다.

		switch(num) {	// 해당 종목의 객체생성 후 선수추가
		case 1:
			players[data] = new Baseball_Player(name,age);
			break;
		case 2:
			players[data] = new Soccer_Player(name,age);
			break;
		case 3:
			players[data] = new Volleyball_Player(name,age);
			break;
		case 4:
			players[data] = new PingPong_Player(name,age);
			break;
		case 5:
			players[data] = new Basketball_Player(name,age);
			break;
		default:
			System.out.println("범위 내의 숫자를 입력해주세요.");
			return;
		}
		System.out.println("추가성공");
		data++;	// 선수 추가가 완료되면 데이터 개수 증가
	}
	public void modifyInfo() {
		System.out.print("수정할 선수이름 입력 : ");
		String name = input.next();
		int index = searchPlayer(name);
		if(index == -1) {
			System.out.println("해당 선수가 존재하지 않습니다.");
			return;
		}
		Field[] infos = players[index].getClass().getDeclaredFields();	// 클래스가 가지고있는 속성 값 저장
		
		for(int i = 0; i < infos.length; i++) {
			System.out.printf("%s, ",infos[i].getName());
		}
		System.out.println();
		System.out.printf("\t수정할 정보를 한줄에 ,구분으로 입력하세요\n");
		System.out.print("입력 : ");
		
		String tmp = input.next();
		tmp += ",";
		System.out.println(tmp);
		String[] str = tmp.split(",");
		
		if(players[index] instanceof Baseball_Player) {
			((Baseball_Player)players[index]).setPosition(str[0]);
			((Baseball_Player)players[index]).setBatting_Rate(Double.parseDouble(str[1]));
			((Baseball_Player)players[index]).setUseHand(str[2].charAt(0));
		}
		else if(players[index] instanceof Basketball_Player) {
			((Basketball_Player)players[index]).setPosition(str[0]);
			((Basketball_Player)players[index]).setFreeDraw_Rate(Double.parseDouble(str[1]));
			((Basketball_Player)players[index]).setHeight(Integer.parseInt(str[2]));
		}
		else if(players[index] instanceof PingPong_Player) {
			((PingPong_Player)players[index]).setStrongPoint(str[0]);
			((PingPong_Player)players[index]).setRacket_Brand(str[1]);
			((PingPong_Player)players[index]).setRacket_Style(str[2]);
		}
		else if(players[index] instanceof Soccer_Player) {
			((Soccer_Player)players[index]).setPosition(str[0]);
			((Soccer_Player)players[index]).setUseLeg(str[1].charAt(0));
			((Soccer_Player)players[index]).setNation(str[2]);
		}
		else {
			((Volleyball_Player)players[index]).setPosition(str[0]);
			((Volleyball_Player)players[index]).setJumpAvg(Double.parseDouble(str[1]));
		}
	}
	public void addArrSize() {
		SportsPlayer[] tmp = new SportsPlayer[players.length];
		tmp = players;
		players = new SportsPlayer[players.length+1];
		System.out.println(players.length);
		for(int i = 0; i < tmp.length; i++) {
			players[i] = tmp[i];
		}
	}
	public void removePlayer() {	// 선수삭제 메서드
		String name;
		System.out.print("삭제할 선수이름 입력 : ");
		name = input.next();

		int index = searchPlayer(name);
		if(index == -1) {
			System.out.println("데이터가 없습니다.");
			return;
		}

		for(int i = index; i < data-1; i++) {	// 삭제할 노드부터 맨 마지막 데이터까지 앞으로 한칸씩 땡겨준다.
			players[i] = players[i+1];
		}
		players[data-1] = null;	// 마지막 자리에 남은 데이터를 null값으로 초기화
		SportsPlayer[] tmp = new SportsPlayer[players.length-1];
		data--;	// 데이터 개 수 감소
	}
	
	public int searchPlayer(String name) {	// 선수이름으로 인덱스 값을 반환하는 메서드
		for(int i = 0; i < data; i++) {
			if(players[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;	// 끝까지 돌아도 해당 선수가 없을 시 -1 리턴

	}

	public void displayByName() {
		String name;
		System.out.print("검색할 선수 이름 입력 : ");
		name = input.next();	
		int index = searchPlayer(name);
		if(index == -1) {
			System.out.println("해당 선수가 존재하지 않습니다.");
			return;
		}
		System.out.println(players[index]);
	}
	public void clearBuf() {
		input.nextLine();
	}
}