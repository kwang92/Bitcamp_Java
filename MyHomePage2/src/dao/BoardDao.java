package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	public boolean updateViewCount(int id) {
		String sql = "update page_board set viewCount = viewCount+1 where b_id = "+id;
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
	public int countTotal(String id) {
		String sql = "select count(*) as total from page_board where mem_id = '"+id+"'";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public boolean addBoard(Board brd, Member mem) {
		String sql = "insert into page_board (b_id, title, context, writer, mem_id)"
				+" values(board_seq.nextval, ?, ?, ?, ?)";
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
	public boolean delBoard(int bid) {
		String sql = "delete from page_board where b_id = "+bid;
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
	public Board selectOne(int id) {
		Board brd = null;
		String sql = "select * from page_board where b_id = "+id;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				brd = new Board();
				brd.setB_id(rs.getInt("b_id"));
				brd.setMem_id(rs.getString("mem_id"));
				brd.setTitle(rs.getString("title"));
				brd.setContext((rs.getString("context")));
				brd.setWriter(rs.getString("writer"));
				brd.setViewCount(rs.getInt("viewCount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return brd;
	}
	public List<Board> getAllBoards(){
		List<Board> bList = new ArrayList<Board>();
		String sql = "select * from page_board";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Board b = new Board();
				b.setB_id(rs.getInt("b_id"));
				b.setTitle(rs.getString("title"));
				b.setContext(rs.getString("context"));
				b.setWriter(rs.getString("writer"));
				b.setViewCount(rs.getInt("viewCount"));
				bList.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return bList;
	}
	public List<Board> getBoardsByName(String name){
		List<Board> bList = new ArrayList<Board>();
		String sql = "select * from page_board where writer like '%"+name+"%'";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Board b = new Board();
				b.setB_id(rs.getInt("b_id"));
				b.setTitle(rs.getString("title"));
				b.setContext(rs.getString("context"));
				b.setWriter(rs.getString("writer"));
				b.setViewCount(rs.getInt("viewCount"));
				bList.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bList;
	}
	public List<Board> getBoardsByTitle(String title){
		List<Board> bList = new ArrayList<Board>();
		String sql = "select * from page_board where title like '%"+title+"%'";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Board b = new Board();
				b.setB_id(rs.getInt("b_id"));
				b.setTitle(rs.getString("title"));
				b.setContext(rs.getString("context"));
				b.setWriter(rs.getString("writer"));
				b.setViewCount(rs.getInt("viewCount"));
				bList.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bList;
	}
}
