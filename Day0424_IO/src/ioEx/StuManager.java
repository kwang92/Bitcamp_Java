package ioEx;

import java.util.Scanner;

public class StuManager extends IOManager{
	private Student s;
	
	public StuManager() {
		s = new Student();
	}
	public void readStudent_Info() {
		byte[] info = readFile();	// IOManager 클래스의 readFile 메소드 호출 후 byte형 반환
		String data = new String(info,0,info.length);
		String str[] = data.split("/");
		System.out.println("받아온 데이터 : "+data);
		
		s.setName(str[0]);
		s.setGrade(Integer.parseInt(str[1]));
		s.setScore(Integer.parseInt(str[2]));
	}
	public void modifyStudent_Info() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("수정할 이름 입력 : ");
		s.setName(input.next());
		System.out.print("수정할 학년 입력 : ");
		s.setGrade(input.nextInt());
		System.out.print("수정할 점수 입력 : ");
		s.setScore(input.nextInt());
		
		writeFile(s);	// IOManager 클래스의 writeFile 메소드 호출
	}
	public void display_Info() {
		System.out.println("이름 : "+s.getName()+", 학년 : "+s.getGrade()+", 점수 : "+s.getGrade());
	}
}