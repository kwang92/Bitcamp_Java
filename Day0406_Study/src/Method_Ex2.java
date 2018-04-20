
public class Method_Ex2 {
	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 3;
		System.out.println(add(num1,num2));
		System.out.println(mod(num1,num2));
	}
	public static int add(int num1, int num2) {
		return (num1 + num2);
	}
	public static int mod(int num1, int num2) {
		return num1 % num2;
	}
}