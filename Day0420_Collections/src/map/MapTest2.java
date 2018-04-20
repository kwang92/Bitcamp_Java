package map;

import java.util.HashMap;
import java.util.Map;

public class MapTest2 {
	public static void main(String[] args) {
		Map<String, Student> m = new HashMap<String, Student>();
		
		Student s1 = new Student("류광민",3,99,100,99);
		m.put(s1.getName().charAt(0)+"", s1);
		
		s1 = new Student("홍길동",2,87,100,100);
		m.put(s1.getName().charAt(0)+"", s1);
		
		s1 = new Student("전우치",4,90,100,77);
		m.put(s1.getName().charAt(0)+"", s1);
		
		s1 = new Student("우투리",1,67,100,99);
		m.put(s1.getName().charAt(0)+"", s1);
		
		s1 = new Student("신사임당",2,100,58,100);
		m.put(s1.getName().charAt(0)+"", s1);
		
		s1 = new Student("홍두깨",5,50,45,71);
		m.put(s1.getName().charAt(0)+"", s1);
		// "홍" key 값 중복으로 인해 홍길동 정보가 없어짐
		
		for(Map.Entry<String, Student> s : m.entrySet()) {
			System.out.println("키 : "+s.getKey()+" [ 정보 : "+s.getValue()+" ]");
		}
		
		
	}
}
