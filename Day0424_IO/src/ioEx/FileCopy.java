package ioEx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		String path = "C:\\Users\\bit\\Desktop\\ryu\\store\\Day0424_IO\\src\\";
		byte[] buffer = new byte[512];
		FileOutputStream out = null;
		FileInputStream in = null;
		int readLength = 0;
		try {
			in = new FileInputStream(path+"iu.png");
			out = new FileOutputStream(path+"iu2.png");
			
			while((readLength = in.read(buffer))!=-1) {
				out.write(buffer,0,readLength);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

		}
		try {
			if(in != null && out != null) {
				in.close();
				out.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
