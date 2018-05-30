package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final static String USER = "kwangmin";
	private final static String PWD = "1";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(URL, USER, PWD);
		System.out.println("provider ¿Ï·á");
		return conn;
	}
}
