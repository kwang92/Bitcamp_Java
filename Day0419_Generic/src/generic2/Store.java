package generic2;

public class Store<T> {
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	public String toString() {
		return "data : "+data;
	}
	
}