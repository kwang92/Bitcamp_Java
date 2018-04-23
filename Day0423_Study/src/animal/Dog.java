package animal;

public class Dog extends Animal{
	public Dog() {
		name = "멍멍이";
		numOfLegs = 4;
	}
	public Dog(String name, int numOfLegs) {
		this.name = name;
		this.numOfLegs = numOfLegs;
	}
	public void sound() {
		System.out.println("멍멍");
	}
	public void getDog() {
		System.out.println("hi");
	}
}