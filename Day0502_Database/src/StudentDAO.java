import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "kwangmin";
	private static final String PWD = "1";
	private Connection conn;
	private Statement stmt;

	public StudentDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	// 드라이버 로딩
			conn = DriverManager.getConnection(URL, USER, PWD);	// 연결

			System.out.println("연결 및 준비 성공");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// insert, update, delete, select, selectAll

	// 내가 조회하려고 하는 데이터를 담을 수 있는 데이터와 동일한 구조를 가지는 객체를 만들어야함 ( Model Class )
	// VO(Value Object), DTO(Data Transfer Object)

	public int insertStudent(Student student) {
		String sql = "insert into student_ex"
				+ " values("+student.getSnum()+",'"
				+student.getSname()+"',"
				+student.getSgrade()+")";

		Statement stmt = null;
		int result = 0;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}
	public int updateStudent(Student student) {
		String sql = "update student_ex"+
				" set snum = "+student.getSnum()+", "+
				"sname = '"+student.getSname()+"', "+
				"sgrade = "+student.getSgrade()+
				" where snum = "+student.getSnum();

		int result = 0;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public int deleteStudent(int snum) {
		String sql = "delete from student_ex"+
				" where snum in "+snum;
		int result = 0;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public Student selectStudent(int snum) {	
		Student rs = null;
		String sql = "select * from student_ex"+
				" where snum = "+snum;

		ResultSet rsSet = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rsSet = stmt.executeQuery(sql);
			if(rsSet.next()) {
				rs = new Student(rsSet.getInt("snum"),rsSet.getString("sname"),rsSet.getInt("sgrade"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs; 
	}
	public List<Student> selectAll(){
		List<Student> rs = new ArrayList<Student>();
		String sql = "select * from student_ex";

		ResultSet rsSet = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rsSet = stmt.executeQuery(sql);
			while(rsSet.next()) {
				rs.add(new Student(rsSet.getInt("snum"),rsSet.getString("sname"),rsSet.getInt("sgrade")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return rs;
	}
}
