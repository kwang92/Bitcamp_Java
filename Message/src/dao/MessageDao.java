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
	private static MessageDao instance;
	private MessageDao() {
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
	public static MessageDao getInstance() {
		
		if(instance == null) {
			instance = new MessageDao();
		}
		return instance;
	}
	public boolean deleteMsg(int id, String pwd) {
		String sql = "delete from message where id = "+ id+" and password = '"+pwd+"'";
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
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
		String sql = "select * from Message order by id desc";
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
	
	public ArrayList<Message> selectList(int firstRow, int endRow){
		ArrayList<Message> mList = new ArrayList<Message>();
		String sql = "select *"+
				" from (select rownum rnum, id, password, name, message"+
				        " from (select rownum r, id, password, name, message"+
				            " from message"+
				                " order by id desc))"+
				"where rnum between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Message msg = new Message();
				msg.setId(rs.getInt("id"));
				msg.setPassword(rs.getString("password"));
				msg.setName(rs.getString("name"));
				msg.setMessage(rs.getString("message"));
				mList.add(msg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mList;
	}
	
	
	public int selectCount() {
		int cnt = 0;
		String sql = "select count(*) from message";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return cnt;
	}
}
