package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Message;

public class MessageDao {
	private Connection conn;
	public MessageDao() {
		try {
			conn = ConnectionProvider.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean sendMsg(Message msg) {
		String sql = "insert into Message"
				+ " values(message_seq.nextval, ?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, msg.getPassword());
			pstmt.setString(2, msg.getName());
			pstmt.setString(3, msg.getMessage());
			pstmt.executeUpdate();
			System.out.println("msg db저장 성공");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("msg db저장 실패");
		return false;
	}
	public ArrayList<Message> getMsgs(){
		ArrayList<Message> list = new ArrayList<Message>();
		String sql = "select * from Message";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new Message(rs.getInt("id")
									,rs.getString("password")
									,rs.getString("name")
									,rs.getString("message")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
