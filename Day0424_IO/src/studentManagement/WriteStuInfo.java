package studentManagement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteStuInfo {
	private ObjectOutputStream out;
	private String path = "C:\\Users\\bit\\Desktop\\ryu\\store\\Day0424_IO\\students.dat";

	public WriteStuInfo() {
		try {
			out = new ObjectOutputStream(new FileOutputStream(path));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeStuInfo_ToFile(MyList<Student> stu) {
		try {
			out.writeObject(stu);
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
