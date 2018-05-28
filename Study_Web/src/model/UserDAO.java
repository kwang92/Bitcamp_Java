package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "kwangmin";
	private static final String PWD = "1";
	private Connection conn;
	
	public UserDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PWD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean addUser(User usr) {
		String sql = "";
		PreparedStatement pstmt = null;
		
		try{
			sql = "insert into user_table values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usr.getUserid());
			pstmt.setString(2, usr.getUserpwd());
			pstmt.setString(3, usr.getName());
			pstmt.setString(4, usr.getGender());
			pstmt.setString(5, usr.getBirth());
			pstmt.executeUpdate();
			
			return true;
		} catch (Exception e){
			e.printStackTrace();
		} 
		return false;
	}
	public int checkUser(User usr) {
		String sql = "";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			sql = "select * from user_table where userid = '"+usr.getUserid()+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String pwd = rs.getString("userpwd");
		
				if(pwd.equals(usr.getUserpwd())) {
					return 2;
				}
				return 1;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
}
