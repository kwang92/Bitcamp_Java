
public class Method_Ex {
	public static void main(String[] args) {
		goSchool("A");
		goSchool("B");
		System.out.println("DO Something");
		goSchool("A");
		goSchool("B");
	}
	public static int goSchool(String name) {
		System.out.println();
		System.out.println(name+"가 일어난다");
		System.out.println(name+"가 씻는다");
		System.out.println(name+"가 밥을먹는다");
		System.out.println(name+"가 버스를탄다");
		System.out.println(name+"가 공부를한다");
		System.out.println(name+"가 귀가를한다");
		System.out.println(name+"가 씻고 잠을잔다.");
		System.out.println();
		
		return 0;
	}
}