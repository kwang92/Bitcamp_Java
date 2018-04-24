package studentManagement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteStuInfo {
	private ObjectOutputStream out;
//	private String path = "C:\\Users\\bit\\Desktop\\ryu\\store\\Day0424_IO\\students.dat";
	private String path = "students.dat";

	public WriteStuInfo() {
	
	}
	public void writeStuInfo_ToFile(MyList<Student> stu) {
		
		System.out.println("stu : "+ stu);
		try {
			out = new ObjectOutputStream(new FileOutputStream(path));
			out.writeObject(stu);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
