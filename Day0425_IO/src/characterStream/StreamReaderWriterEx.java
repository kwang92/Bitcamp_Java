package characterStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamReaderWriterEx {
	public static void main(String[] args) {
		// InputStreamReader, OutputStreamWriter
		// 바이트 스트림과 문자 스트림의 중간다리 역할
		// InputStream, OuputStream 주로 많이 사용
		// 바이트스트림을 문자스트림으로 바꿔야 되는 경우에 사용
		// System.in (표준입력), System.out(표준출력)을 문자 스트림으로 출력해보기
		// 표준입출력은 바이트 스트림이므로 Reader, Writer를 사용하기 위해서는
		// InputStream, OutputStream이 필요하다.
		BufferedReader br = null;
		BufferedWriter bw = null;
	
		// 중간다리 역할을 할 reader, writer
		InputStreamReader reader = null;
		OutputStreamWriter writer = null;
		
		reader = new InputStreamReader(System.in);
		writer = new OutputStreamWriter(System.out);
		
		br = new BufferedReader(reader);
		bw = new BufferedWriter(writer);
		
		
		try {
			String id = br.readLine();
			bw.write("id : "+id+"\n");
			bw.flush();
			
			String pw = br.readLine();
			bw.write("pw : "+pw+"\n");
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}