package studentManagement;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadStuInfo {
	private ObjectInputStream in;
	private String path = "C:\\Users\\bit\\Desktop\\ryu\\store\\Day0424_IO\\students.dat";

	public ReadStuInfo() {

		try {
			in = new ObjectInputStream(new FileInputStream(path));
			System.out.println("현재 in"+in);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}

	}
	public MyList<Student> getStuInfo_ByFile() {

		MyList<Student> tmp = null;
		if(in != null) {
			try {
				
				try {
					tmp = (MyList<Student>) in.readObject();
				} catch (EOFException e) {
					System.out.println("왜 여기들어옴?");
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return tmp;

			} catch (ClassNotFoundException e) {

			}

		} 

		try {
			if(in != null) {
				in.close();
			}
		} catch (IOException e) {}
		return tmp;
	}
}
