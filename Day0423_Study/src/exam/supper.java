package exam;

public class supper {
	protected int a;
	private int b;
	public void setVar() {
		
	}
}
class sub extends supper{
	public void printmsg() {
		System.out.println(a);
	}
}
class sub2{
	public static void main(String[] args) {
		sub a = new sub();
		a.setVar();
	}
}
