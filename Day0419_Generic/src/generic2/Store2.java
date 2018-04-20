package generic2;

public class Store2<T, V> {	// 제네릭은 <> 안에 여러 가지 또한 올 수 있다.
	private T var1;
	private V var2;
	public T getVar1() {
		return var1;
	}
	public void setVar1(T var1) {
		this.var1 = var1;
	}
	public V getVar2() {
		return var2;
	}
	public void setVar2(V var2) {
		this.var2 = var2;
	}
	
	
}
