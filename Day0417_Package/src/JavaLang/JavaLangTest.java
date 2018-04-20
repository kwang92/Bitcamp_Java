package JavaLang;

public class JavaLangTest {
	public static void main(String[] args) {
		// String, Math, Wrapper Class 등등
	
		System.out.println(Math.abs(-5));
		String num = "13184";
		
		int num2 = Integer.parseInt(num);
		System.out.println(num2-1);
	
		StringBuilder sb = new StringBuilder();	// 메서드 체이닝기법 ( 메서드의 반환형이 객체 자기자신이기 때문에 다시 메서드 호출가능)
		StringBuilder sb2 = new StringBuilder();
		System.out.println(sb);
		
		sb.append("hello");
		sb2.append("hello");
		String str14 = "13598";
		int a = Integer.parseInt(str14);
		
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		System.out.println(sb == sb2);
		System.out.println(str1 == str2);
		
	}
}