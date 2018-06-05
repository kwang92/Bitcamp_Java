package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Board;
import model.Member;

public class BoardDao {
	private static BoardDao dao;
	private Connection conn;
	
	private BoardDao() {
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
	public static BoardDao getInstance() {
		if(dao == null) {
			dao = new BoardDao();
		}
		return dao;
	}
	public boolean addBoard(Board brd, Member mem) {
		String sql = "insert into page_board values(board_seq.nextval(),?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brd.getTitle());
			pstmt.setString(2, brd.getContext());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getMem_id());
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
