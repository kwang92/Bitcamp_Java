package linkedlist;

public class Node{	// 문자열 저장 노드
	private String data;
	private Node next;
	
	public Node() {}
	public Node(String data) {
		this.data = data;
		this.next = null;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Node next() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return data+" ";
	}
	
	
}
