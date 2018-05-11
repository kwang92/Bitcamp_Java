package commons;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class EnumTest {
	public static void main(String[] args) {
		System.out.println(Member.ID.getCol());
		System.out.println(Member.REG_DATE.getCol());
		
		Member e1 = Member.ID;
		Map<Member, Object> map = new HashMap<Member,Object>();
		map.put(Member.ID, "123");
		
	}
}
