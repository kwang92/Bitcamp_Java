package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Board;

public class BoardDaoImp implements BoardDao{
	private Connection conn;
	private static BoardDao imp;
	private BoardDaoImp() {
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
	public static BoardDao getInstance() {
		if(imp == null) {
			imp = new BoardDaoImp();
		}
		return imp;
	}
	
	@Override
	public int insertBoard(Board board) {
		String sql = "insert into myBoard (num,title,name,pass,email,content)"
				+ " values(myBoard_seq.nextval,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getPass());
			pstmt.setString(4, board.getEmail());
			pstmt.setString(5, board.getContent());
			result = pstmt.executeUpdate();
			System.out.println("insert execute 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("result 반환");
		return result;
	}

	@Override
	public int updateBoard(Board board) {
		String sql = "update myBoard set"
						+ " title = ?,"
						+ " name = ?,"
						+ " pass = ?,"
						+ " email = ?,"
						+ " content = ?"
						+ " where num = ?";
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getPass());
			pstmt.setString(4, board.getEmail());
			pstmt.setString(5, board.getContent());
			pstmt.setInt(6, board.getNum());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public int updateViewCount(String num) {
		String sql = "update myBoard set readCount = readCount+1"
					+ " where num = '"+num+"'";
		Statement stmt = null;
		int result = 0;
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteBoard(int num) {
		String sql = "delete from myBoard where num = "+num;
		Statement stmt = null;
		int result = 0;
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Board selectOne(String num) {
		String sql = "select * from myBoard where num = "+num;
		Statement stmt = null;
		ResultSet rs = null;
		Board board = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				board = new Board();
				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setName(rs.getString("name"));
				board.setPass(rs.getString("pass"));
				board.setEmail(rs.getString("email"));
				board.setContent(rs.getString("content"));
				board.setReadCount(rs.getInt("readCount"));
				board.setWriteDate(rs.getDate("writeDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public List<Board> selectAll() {
		String sql = "select * from myBoard";
		Statement stmt = null;
		ResultSet rs = null;
		List<Board> bList = new ArrayList<Board>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Board board = new Board();
				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setName(rs.getString("name"));
				board.setPass(rs.getString("pass"));
				board.setEmail(rs.getString("email"));
				board.setContent(rs.getString("content"));
				board.setReadCount(rs.getInt("readCount"));
				board.setWriteDate(rs.getDate("writeDate"));
				bList.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bList;
	}

}
