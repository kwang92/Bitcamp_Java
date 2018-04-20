package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapTest3 {
	public static void main(String[] args) {
		// 데이터를 전달할 때 많이 사용한다.
		// 하지만 데이터의 종류가 매우 다양하기 때문에 모든 데이터를 한꺼번에 담아서 처리할
		// 자료구조가 필요
		Map<String,Object> map = new HashMap<String,Object>();	
			// 다양한 type의 데이터를 처리하기 위해 value값으로는 Object를 지정해준다.
		List<Student> stu_List = new ArrayList<Student>();
		stu_List.add(new Student());
		stu_List.add(new Student());
		stu_List.add(new Student());
		
		map.put("student", new Student("류광민",2,100,98,88));
		map.put("phone", "010-8660-7532");
		map.put("number", 201231014);
		map.put("List", stu_List);
		
		Student s = (Student)map.get("student");
		String phone = (String)map.get("phone");
		int id = (int)map.get("number");
		
		System.out.println(s);
		System.out.println(phone + "  "+id);
		
		List<Student> li = (ArrayList)map.get("List");
		for(Student si : li) {
			System.out.println(si);
		}
		
		List<List<Student>> tt = new ArrayList<List<Student>>();
		List<Student> st = new ArrayList<Student>();
		st.add(new Student());
		st.add(new Student());
		tt.add(st);
		
		// tt 는 리스트를 담는 리스트 
		// st는 학생클래스를 담는 리스트
		
		Iterator it = tt.get(0).iterator();
		while(it.hasNext()) {
			System.out.println("학생");
			System.out.println(it.next());
		}
	}
}