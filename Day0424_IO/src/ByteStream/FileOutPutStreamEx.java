package ByteStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutPutStreamEx {
	public static void main(String[] args) {
		String path = "C:\\Users\\bit\\Desktop\\ryu\\store\\Day0424_IO\\src\\write.txt";
		String msg = "Hello world!!!";
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(path);
			byte[] data;
			try {
				data = msg.getBytes();
				for(int i = 0; i < data.length; i++) {
					System.out.print(data[i]+" ");
				}
				out.write(data);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
// hello world ==> byte[]  2 byte
// 							1 byte
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(out != null) {
					out.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
