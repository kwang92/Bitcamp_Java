package ioEx;



public class StuTest {
	public static void main(String[] args) {
		StuManager sm = new StuManager();
		sm.readStudent_Info();
		sm.display_Info();
		
		sm.modifyStudent_Info();
		sm.display_Info();
	}
}