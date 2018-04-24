package studentManagement;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadStuInfo {
	private ObjectInputStream in;
	private FileInputStream fin;
	//private String path = "C:\\Users\\bit\\Desktop\\ryu\\store\\Day0424_IO\\students.dat";
	private String path = "students.dat";

	public ReadStuInfo() {

		try {
			fin = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	public MyList<Student> getStuInfo_ByFile() {
		MyList<Student> tmp = null;

		if(fin == null) {	// 최초 1회는 student.dat 파일이 없으므로 메소드 종료
			System.out.println("최초 1회는 받아오지않습니다.");
			return null;
		}
		try {
			in = new ObjectInputStream(fin);
			tmp = (MyList<Student>) in.readObject();
			
			System.out.println("try안 tmp"+ tmp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(in != null && fin != null) {
					in.close();
					fin.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return tmp;
	}
}