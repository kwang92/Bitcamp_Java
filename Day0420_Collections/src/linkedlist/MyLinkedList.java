package linkedlist;

public class MyLinkedList {
	private Node head;
	private int len;
	
	public MyLinkedList() {
		head = null;
	}
	public void add(String data) {	// Tail Node를 가져와 next를 새 Node로 set해주고 size를 1 늘려준다.
		Node newNode = new Node(data);
		if(isEmpty()) {
			head = newNode;
		}
		else {
			getTail().setNext(newNode);	
		}
		len++;
	}
	public void remove(int index) {
		if(isEmpty()) {
			System.out.println("지울 데이터가 없습니다.");
			return;
		}
		Node current = head;
		for(int i = 1; i < index; i++) {
			current = current.next();
		}
		if(current == head) {
			head = head.next();
			len--;
			return;
		}
		current.setNext(current.next().next());
		len--;
	}
	public Node get(int index) {
		Node current = head;
		for(int i = 1; i < len; i++) {
			current = current.next();
			if(i == index)
				return current;
		}
		return current;
	}
	public void set(int index, String data) {
		if(index >= len) {
			System.out.println("해당 Index Node가 존재하지 않습니다.");
			return;
		}
		Node current = head;
		for(int i = 0; i < index; i++) {
			current = current.next();
			if(i == index) {
				break;
			}
		}
		current.setData(data);
	}
	public Node getTail() {	// Node의 개 수 -1 만큼의 Node의 Next로 이동한 후 해당 Node를 반환한다.
		Node tail = head;
		while(tail.next() != null) {
			tail = tail.next();
		}
		return tail;
	}
	public int size() {
		return len;
	}
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		Node current = head;
		for(int i = 0; i < len; i++) {
			result.append(current.getData()).append(" ");
			current = current.next();
		}	
		return result+"";
	}
	public boolean isEmpty() {
		boolean empty = false;
		if(head == null) {
			return !empty;
		}
		return empty;
	}
}
