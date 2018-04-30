package mouseEvent;

public class SplitTest {
	public static void main(String[] args) {
		String tt = "login##rkm92##rkw";
		String[] sp = tt.split("(##)");
		
		for(int i = 0; i < sp.length; i++) {
			System.out.println(sp[i]);
		}
	}
}
