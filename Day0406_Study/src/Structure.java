import java.util.ArrayList;

public class Structure {
	public static void main(String[] args) {
		ArrayList <Student> stu = new <Student>ArrayList();
		
		for(int i = 0; i < 10; i++) {
			stu.addAll(new <Student>ArrayList());
		}
		
	}
}	
class Student{
	private String name;
	private String school;
	private int grade;
	private double score;
	private int age;
	
	public Student() {};
	public Student(String name, String school, int age) {
		this.name = name;
		this.school = school;
		this.age = age;
		this.grade = 1;
		this.score = 0;
	}

	public void display() {
		System.out.println(name+" "+school+" "+grade+" "+score+" "+age);
	}
}