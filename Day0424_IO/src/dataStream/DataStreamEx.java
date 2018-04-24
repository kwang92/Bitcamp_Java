package dataStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamEx {
	public static void main(String[] args) {
		// 데이터 처리 스트림
		// DataInputStream, DataOutputStream
		// byte 단위로 데이터를 쓰던 것을, 자바 기초자료형 단위로 데이터를 쓸 수 있게 구현해놓은 스트림
		String path = "data.dat";
		DataInputStream in;
		DataOutputStream out;
		try {	// 저장 할때 순서대로 한 대로 읽어 올 때도 그 순서대로 읽어온다.
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
			in = new DataInputStream(new BufferedInputStream(new FileInputStream(path)));
			
			out.writeInt(100);
			out.writeDouble(3.14);
			out.writeBoolean(false);
			out.writeUTF("hello world");// writeUTF 는 문자여을 WRITE함
			out.flush();	// 버퍼가 꽉차지 않았을 때도 data를 내보내기 (출력)하기 위해 flush() 메소드 사용
			
			int intNum = in.readInt();
			double doubleNum = in.readDouble();
			boolean bool = in.readBoolean();
			String str = in.readUTF();	// 그대로 문자열을 read 함
			System.out.println(intNum+" "+doubleNum + " " + bool);
			System.out.println(str);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
