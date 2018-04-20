package JavaLang;

import java.util.Calendar;

public class JavaUtilTest {
	public static void main(String[] args) {
		// Date, Calender, StringTokenizer
		Calendar cal = Calendar.getInstance();	// Calendar 객체 생성
		
		// 1-연도, 2
		cal.set(cal.YEAR,2012);
		System.out.println(cal.getTime());
		cal.set(cal.MONTH,11);
		System.out.println(cal.getTime());
		cal.set(cal.DATE, 12);
		System.out.println(cal.getTime());
		
		// 날짜 저장은 Date 클래스, 수정 및 변경은 Calendar 클래스를 이용
		
		
		
		
	}
}