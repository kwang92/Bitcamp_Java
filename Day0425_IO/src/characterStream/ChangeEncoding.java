package characterStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ChangeEncoding {
	// 문서 인코딩 방법 바꾸기
	public static void main(String[] args) {
		// UTF-8로 작성된 문서를 일어서 MS949방식의 인코등으로 바꾸어서 복사
		// 파일 읽어오기 위해서 FileInputStream, 쓰기위해서 FileOutputStream

		BufferedReader in = null;
		BufferedWriter out = null;
		
		int readChar;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream("test.java"),"UTF-8"));
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test.java"),"UTF-8"));
			
			while((readChar = in.read()) != -1) {
				
			}
		} catch(IOException e) {
			
		}
		
		
	}


}
