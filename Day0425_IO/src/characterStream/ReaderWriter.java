package characterStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriter {
	public static void main(String[] args) {
		FileReader reader = null;
		FileWriter writer = null;
		int readChar;
		// 파일로부터 데이터를 read해서 복사할 파일에 write
		try {
			reader = new FileReader("test.txt");
			writer = new FileWriter("test_copy.txt");

			while((readChar = reader.read()) != -1) {
				writer.write((char)readChar);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(reader != null && writer != null) {
					reader.close();
					writer.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
