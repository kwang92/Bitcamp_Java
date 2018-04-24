package ByteStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamEx {
	public static void main(String[] args) {
		/* 	데이터 처리 스트림 - ( BufferedInput / OutputStream )
		 *  데이터 처리 스트림 : 데이터 소스에서 값을 가져오거나 쓰는게 아니라
		 *                데이터를 받아서 쓰기 편하게 만들어주는 역할
		 */
		String path = "./test.txt";
		FileInputStream in = null;
		FileOutputStream out = null;

		BufferedInputStream b_in = null;
		BufferedOutputStream b_out = null;

		try {
			out = new FileOutputStream(path);
			b_out = new BufferedOutputStream(out);

			for(int i = 1; i <= 300; i++) {
				b_out.write(i);
			}
			b_out.flush();
			
			in = new FileInputStream("./test.txt");
			b_in = new BufferedInputStream(in);
			
			int data;
			while( ( data = b_in.read() ) != -1) {
				System.out.println(data);
			}
		} catch ( NoSuchFieldError e) {
			e.printStackTrace();
		} catch ( IOException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		

	}
}
