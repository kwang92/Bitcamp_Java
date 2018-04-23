package linkedlist;

public class Node<T>{	// 저장 Node ( generic )
	private T data;
	private Node<T> next;
	
	public Node() {}
	public Node(T data) {
		this.data = data;
		this.next = null;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node next() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return data+" ";
	}
}
