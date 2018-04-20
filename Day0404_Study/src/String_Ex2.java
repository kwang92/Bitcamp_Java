
public class String_Ex2 {
	public static void main(String[] args) {
		// "no news is good news" 에서 반복문을 사용해서  문자n의 개수 출력
		
		String state = "no news is good news";
		int n_Count = 0;
		
		for(int i = 0; i < state.length(); i++) {
			if(state.charAt(i) == 'n' ) {
				n_Count++;
			}
		}
		System.out.println("'n'의 개수는 "+n_Count+"개 입니다.");
	}
}