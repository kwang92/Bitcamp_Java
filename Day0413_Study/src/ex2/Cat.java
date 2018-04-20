package ex2;

public class Cat extends Animal{
	public Cat() {
		name = "야옹이";
		numOfLegs = 4;
	}
	public Cat(String name, int numOfLegs) {
		this.name = name;
		this.numOfLegs = numOfLegs;
	}
	public void sound() {
		System.out.println("야옹");
	}
}
