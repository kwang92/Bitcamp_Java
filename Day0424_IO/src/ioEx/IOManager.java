package ioEx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOManager {
	private String path = "C:\\Users\\bit\\Desktop\\ryu\\store\\Day0424_IO\\src\\stu.txt";
	private FileInputStream in;
	private FileOutputStream out;
	public IOManager() {
		in = null;
		out = null;
	}
	public byte[] readFile() {
		byte[] data = null;
		String str = "";
		
		try {
			in = new FileInputStream(path);
			int tmp;
			
			try {
				while(( tmp = in.read() ) != -1) {
					str += (char)tmp;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if( in != null ) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		data = str.getBytes();
		return data;
	}
	public void writeFile(Student s) {
		try {
			out = new FileOutputStream(path);
			String str = s.getName()+"/"+s.getGrade()+"/"+s.getScore();
			try {
				out.write(str.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
