import java.util.ArrayList;

public class StuTest {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		ArrayList<ArrayList> b = new ArrayList<ArrayList>();
		
		a.add("hi");
		a.add("hello");
		b.add(a);
		b.get(0).get(0);
		
		HighStudent hs = new HighStudent();
		hs.score.setEng(90);
		hs.score.setkor(87);
		hs.score.setMath(76);
		
		Student s = new Student();
		s = hs;
		System.out.println(s.score.getSum());
		((HighStudent)s).setDep("이과");
		System.out.println(((HighStudent)s).getDep());
	}
}