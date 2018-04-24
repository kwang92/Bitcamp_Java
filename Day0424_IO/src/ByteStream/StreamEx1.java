package ByteStream;
import java.io.IOException;

public class StreamEx1 {
	public static void main(String[] args) {
		// System.in -> Standard input stream
		// 키보드로부터 들어오는 입력 처리
		// Stream으로 부터 데이터를 읽어와서 화면에 아스키코드로 출력
		// 읽어온 데이터가 q, Q라면 출력하지 않고 종료
		
		try {
			char ch;
			int num;
			System.out.println("문자를 입력하세요");
			do {
				num = System.in.read();
				ch = (char)num;
				if(num == '\n' || num == '\r') {
					continue;
				}
				System.out.println("[ "+ch+" ] "+num);
			}while(ch != 'q' || ch != 'Q' );
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
