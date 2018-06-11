package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.FileUpload;

public class FileDao {
	private static FileDao dao;
	private Connection conn;
	private FileDao() {
		try {
			conn = ConnectionProvider.getConnect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static FileDao getInstance() {
		dao = new FileDao();
		return dao;
	}
	public boolean insertFile(String fileName) {
		String sql = "insert into uploadfile(filename) values(?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fileName);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public List<String> selectAll(){
		List<String> list = new ArrayList<String>();
		String sql = "select * from uploadfile";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String[] splits = rs.getString("filename").split("_");
				list.add(splits[splits.length-1]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
