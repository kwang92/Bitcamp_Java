package generic1;

public class StoreTest {
	public static void main(String[] args) {
		Store s = new Store();
		s.setData(7);	
		int num = 5;

		if(s.getData() instanceof Integer) {
			System.out.println("조건안");
		}
		else if(s.getData() instanceof Double) {
			
		}
		else if(s.getData() instanceof String) {
			
		}
		/*
		System.out.println((int)s.getData() + 7);

		s.setData("str");
		System.out.println("My"+s.getData());

		s.setData(1.33);
		System.out.println((double)s.getData()+0.5);

		s.setData('c');
		System.out.println("My"+s.getData());
*/



	}
}