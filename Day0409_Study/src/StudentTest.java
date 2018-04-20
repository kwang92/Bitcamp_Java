
public class StudentTest {
	public static void main(String[] args) {
		Student km = new Student("류광민","201231014");
		km.display_Info();
		
//		System.out.println();
		/*
		Student kd = new Student();
		kd.setName("홍길동");
		kd.setId("201831055");
		kd.setGrade(3);
		kd.display_Info();*/
		
		System.out.println(km);
	}
}
class Student{
	private String name;
	private String id;
	private int grade;
	
	public Student() {};
	public Student(String name, String id) {
		this.name = name;
		this.id = id;
		grade = 1;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void display_Info() {
		System.out.println("이름 :"+name+"  학번 :"+id+"  학년 :"+grade);
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public int getGrade() {
		return grade;
	}
	public String toString() {
		return "이름 :"+name+"  학번 :"+id+"  학년 :"+grade;
	}
}
