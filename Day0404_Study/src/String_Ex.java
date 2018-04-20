import java.util.Scanner;

public class String_Ex {
	public static void main(String[] args) {
		// 문자열비교는 equals() 메소드를 사용한다. (String 클래스)
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String s1 = in.nextLine();
		
		
		if(s.charAt(0) == s1.charAt(0)) {
			System.out.println("같음");
		}else {
			System.out.println("다름");
		}
		System.out.println(s.substring(0, 4));
		
		// String.trim() 메소드 --> 문자열 앞, 뒤 쪽 공백 제거해준 문자열을 return 해줌
		// String.contains(string) --> 문자열속에 해당 문자열이 포함되어 있는지 아닌지에 대한 boolean 값 return
		
	}
}