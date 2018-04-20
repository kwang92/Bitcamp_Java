
public class AdderTest {
	public static void main(String[] args) {
		Adder add = new Adder();
		add.addNums(5, 7);
		add.display();
		
		Adder add2 = new Adder();
	}
}
class Adder{
	int num1, num2, sum;
	
	public void addNums(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
		sum = this.num1 + this.num2;
	}
	public void display() {
		System.out.println("결과는 "+sum+"입니다.");
	}
}