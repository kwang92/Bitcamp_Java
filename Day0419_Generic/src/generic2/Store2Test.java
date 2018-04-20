package generic2;

public class Store2Test {
	public static void main(String[] args) {
		Store2<String, Integer> store = new Store2<String, Integer>();
		
		store.setVar1("asdasdsadsad");
		store.setVar2(23523125);
		System.out.println(store.getVar1() + store.getVar2());
	}
}
