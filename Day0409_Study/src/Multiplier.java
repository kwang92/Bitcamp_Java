
public class Multiplier {
	private int num1, num2;
	private int result;
	
	public Multiplier() {};
	public Multiplier(int num1) { 
		this.num1 = num1;
	}
	public Multiplier(double num2) {
		this.num2 = (int)num2;
	}
	public Multiplier(int num1, int num2) { 
		this.num1 = num1; this.num2 = num2;
	}
	
	public int computeMul() {
		result = num1 * num2;
		return result;
	}
	public int computeMul(int num1, int num2) {
		result = num1 * num2;
		return result;
	}
	public void display() {
		System.out.println("num1은 "+num1+" num2는"+num2);
	}
}
// 