package collection;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
public class CollectionTest{
	public static void main(String[] args) {
		/*
		 * 	컬렉션(Collection ) : 자료구조를 구현해놓은 클래스, (인터페이스)
		 *   -> List, Set, Stack, Queue, Map  = 인터페이스 
		 *   List : ArrayList, LinkedList (Array, Linked 둘다 List interface를 상속 받아있음)
		 *   Set  : HashSet
		 *   Map  : HashMap
		 */
		List<String> list = new LinkedList<String>();
		list.add("hello");
		list.add("world");
		list.add("!!");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		list.remove(1);
		System.out.println();
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+ " ");
		}
	}
}