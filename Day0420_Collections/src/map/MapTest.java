package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		// Map은 key값은 unique 해야한다( 중복 불가능 ) , 하지만 value값은 중복 허용
		// Map 구현 클래스 -> HashMap
		// Map의 키가 있는지 여부를 검사 -> Map 객체이름.containsKey(key value); = key가 있으면 true 반환, 없으면 false 반환
	
		Map<Integer,String> map = new HashMap<Integer,String>();
		int key = 1;
		map.put(key++, "사과");
		map.put(key++, "배");
		map.put(key++, "포도");
		map.put(key++, "귤");
		map.put(key++, "오렌지");
		
		System.out.println(map.entrySet());
		
		System.out.println("*****************");
		// 요소 가져오기 방법 1
		for(Map.Entry<Integer, String> s : map.entrySet()) {	// Map은 foreach로 모든 요소를 꺼내올 수 가 있다.
			System.out.println(s.getKey()+", "+s.getValue());
		}

		// 요소 가져오기 방법 2
		Set<Integer> keyset = map.keySet();	// HashMap의 key set을 얻어 올수 있다.
		for(int num : keyset) {
			String str = map.get(num);
			System.out.println(num+", "+str);
		}
		
		// 요소 가져오기 방법 3
		Iterator<Integer> it = keyset.iterator();
		while(it.hasNext()) {
			int key_Num = it.next();
			String str = map.get(key_Num);
			System.out.println(key_Num+", "+str);
		}
	}
}
