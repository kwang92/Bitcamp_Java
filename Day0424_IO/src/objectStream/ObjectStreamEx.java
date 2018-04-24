package objectStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import ioEx.Student;

public class ObjectStreamEx {
	public static void main(String[] args) {
		// serialize(직렬화) : 객체를 전송가능한 형태로 변경하는 것 
		// 전송할 객체에 Serializable을 implements 해준다. (메소드는 구현 해줄 필요 없음)
		// 클래스 정보가 변경되었을 때, 직렬화해서 객체를 만들어내면 문제가 발생할 수 있다.
		// 그래서 클래스의 버전 정보를 저장하는 변수를 둬서 객체가 업데이트 되었는지 확인. ( ioEx 패키지의 Student 클래스 확인 )
		
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		String path = "date.txt";
		
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(path)));
			
			Student s = new Student();
			s.setName("류광민");
			s.setGrade(4);
			s.setScore(100);
			
			out.writeObject(s);
			out.flush();
			
			in = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(path)));
			Student tmp = (Student)in.readObject();
			System.out.println(tmp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
