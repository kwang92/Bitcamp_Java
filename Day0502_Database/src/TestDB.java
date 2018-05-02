import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {
	// "jdbc:oracle:thin:@localhost:1521:XE";
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "kwangmin";
		String pwd = "1";
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	// Class.forname 지정 오라클 제이디비씨 드라이버 오라클드라이버
			conn = DriverManager.getConnection(url,user,pwd);	// Connection 객체에 드라이버매니져로 겟 커넥션
			Statement stmt = conn.createStatement();			// Statement 객체에 connection객체로부터 statement생성
			String sql = "";
			
			
			
					
//			sql = "insert into student_ex values(6,'신사임당',4)";
//			stmt.executeUpdate(sql);
			
//			sql = "select * from student_ex order by snum asc";
			sql = "select * from student_ex where snum in 6";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getInt("snum")+" ");
				System.out.print(rs.getString("sname")+" ");
				System.out.println(rs.getInt("sgrade"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
