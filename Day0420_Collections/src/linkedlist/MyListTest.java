package linkedlist;

public class MyListTest {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.add("A");
		list.add("B");
		
		System.out.println(list);
		System.out.println("=================");

		list.set(0, "F");
		System.out.println(list);
		System.out.println("=================");
		
		list.remove(0);
		System.out.println(list);
		System.out.println("=================");

		list.remove(0);
		System.out.println(list);
		System.out.println("=================");

		list.add("B");
		System.out.println(list);
		System.out.println("=================");
		list.add("C");
		System.out.println(list);
		System.out.println("=================");
		list.add("D");
		System.out.println(list);
		System.out.println("=================");
		list.set(2,"E");
		System.out.println(list);
		System.out.println("=================");
		list.remove(2);
		System.out.println(list);
		System.out.println("=================");
		list.set(2, "F");
		System.out.println(list);
		System.out.println("=================");
		list.set(1, "F");
		System.out.println(list);
		System.out.println("=================");
		
		System.out.println(list.get(1));
	}
}