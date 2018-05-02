import java.util.ArrayList;
import java.util.List;

public class StudentDAO_Test {
	
	public static void main(String[] args) {
		StudentDAO sd = new StudentDAO();
		List<Student> test = new ArrayList<Student>();

		test = sd.selectAll();
		for(int i = 0; i < test.size(); i++) {	// selectAll Test
			System.out.println(test.get(i));
		}
		System.out.println();
		
		System.out.println(sd.deleteStudent(7)+"개의 행 삭제");	// delete Test
		test = sd.selectAll();
		for(int i = 0; i < test.size(); i++) {	// selectAll Test
			System.out.println(test.get(i));
		}
		System.out.println();
		
		System.out.println(sd.selectStudent(2));	// snum으로 선택한 1 student만 select해서 조회
		/*
		System.out.println(sd.insertStudent(new Student(7,"그루트",3))+"개의 행 추가");	// insert Test
		test = sd.selectAll();
		for(int i = 0; i < test.size(); i++) {	// selectAll Test
			System.out.println(test.get(i));
		}
		System.out.println();
		
	
		System.out.println(sd.updateStudent(new Student(6,"사임당",5))+"개의 행 업데이트");	// update Test
		System.out.println();*/
	}
}
