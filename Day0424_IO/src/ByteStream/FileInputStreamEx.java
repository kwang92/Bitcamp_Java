package ByteStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx {
	public static void main(String[] args) {
		// File로 부터 데이터를 읽어오기
		FileInputStream in = null;
		try {
			String str = "";
			in = new FileInputStream("C:\\Users\\bit\\Desktop\\ryu\\store\\Day0424_IO\\src\\data.txt");
			int data;
			while(( data = in.read() ) != -1) {
				str += (char)data;
			}
			System.out.println(str);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 없습니다.");
		} catch (IOException e) {

		} finally {
			try {
				if(in != null) {
					in.close();
				}
			}catch (IOException e) {

			}
		}
	}
}
