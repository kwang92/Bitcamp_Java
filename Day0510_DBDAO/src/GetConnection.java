import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "kwangmin";
	private static final String PWD = "1";
	public static Connection GetConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(URL,USER,PWD);
		return conn;
	}
}
