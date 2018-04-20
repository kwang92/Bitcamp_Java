package map;

import java.util.HashMap;
import java.util.Map;

public class MapTest2 {
	public static void main(String[] args) {
		Map<String, Student> m = new HashMap<String, Student>();
		
		Student s1 = new Student("류광민",3,100,100,100);
		m.put(s1.getName().charAt(0)+"", s1);
		
		s1 = new Student("홍길동",2,100,100,100);
		m.put(s1.getName().charAt(0)+"", s1);
		
		s1 = new Student("전우치",4,100,100,100);
		m.put(s1.getName().charAt(0)+"", s1);
		
		s1 = new Student("우투리",1,100,100,100);
		m.put(s1.getName().charAt(0)+"", s1);
		
		s1 = new Student("신사임당",2,100,100,100);
		m.put(s1.getName().charAt(0)+"", s1);
		
		for(Map.Entry<String, Student> s : m.entrySet()) {
			System.out.println("키 : "+s.getKey()+" , 정보 : "+s.getValue());
		}
	}
}
