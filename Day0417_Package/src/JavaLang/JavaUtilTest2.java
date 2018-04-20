package JavaLang;

import java.util.StringTokenizer;

public class JavaUtilTest2 {
	public static void main(String[] args) {
		// StringTokenizer  - 문자열을 특정한 문자 기준으로 잘라주는 역할을 하는 클래스
		String member = "홍길동/123@/hong123/hong@email.com";
		StringTokenizer st = new StringTokenizer(member,"/");
		
		
		String str;
		while( st.hasMoreTokens()) {	// hasMoreTokens는 다음 토큰이 있는지 없는지 여부를 검토
			System.out.println(st.nextToken());
		}
		
		
		/*
		for(String str : member.split("/")) {
			System.out.println(str);
		}*/
		
	}
}
