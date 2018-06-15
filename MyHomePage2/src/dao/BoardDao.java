package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Board;
import model.Member;


public class BoardDao {
	private static BoardDao dao;
	private Connection conn;

	private BoardDao() {}
	public static BoardDao getInstance() {
		if(dao == null) {
			dao = new BoardDao();
		}
		return dao;
	}

	public int selectCount() {
		int cnt = 0;
		String sql = "select count(*) from page_board";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionProvider.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return cnt;
	}
	public boolean updateBoard(Board brd) {
		String sql = "update page_board set title = ?,"
				+ "							context = ?"
				+ "	  where b_id = "+brd.getB_id();
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brd.getTitle());
			pstmt.setString(2, brd.getContext());
			int num = pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return false;
	}
	public boolean updateViewCount(int id) {
		String sql = "update page_board set viewCount = viewCount+1 where b_id = "+id;
		Statement stmt = null;
		try {
			conn = ConnectionProvider.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return false;
	}
	public int countTotal(String id) {
		String sql = "select count(*) as total from page_board where mem_id = '"+id+"'";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionProvider.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return 0;
	}
	public boolean addBoard(Board brd, Member mem) {
		String sql = "insert into page_board (b_id, title, context, writer, mem_id)"
				+" values(board_seq.nextval, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		String text = brd.getContext().replaceAll("<(/)?([a-zA-Z]*)(\\\\s[a-zA-Z]*=[^>]*)?(\\\\s)*(/)?>", "");
		brd.setContext(text);
		try{
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brd.getTitle());
			pstmt.setString(2, brd.getContext());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getMem_id());
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return false;
	}
	public boolean delBoard(int bid) {
		String sql = "delete from page_board where b_id = "+bid;
		Statement stmt = null;

		try {
			conn = ConnectionProvider.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

		return false;
	}
	public Board selectOne(int id) {
		Board brd = null;
		String sql = "select * from page_board where b_id = "+id;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionProvider.getConnection();
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

		return brd;
	}
	public List<Board> getAllBoards(){
		List<Board> bList = new ArrayList<Board>();
		String sql = "select * from page_board";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionProvider.getConnection();
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}


		return bList;
	}
	public List<Board> getBoardsByName(String name){
		List<Board> bList = new ArrayList<Board>();
		String sql = "select * from page_board where writer like '%"+name+"%'";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionProvider.getConnection();
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

		return bList;
	}
	public List<Board> getBoardsByTitle(String title){
		List<Board> bList = new ArrayList<Board>();
		String sql = "select * from page_board where title like '%"+title+"%'";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionProvider.getConnection();
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

		return bList;
	}
	public ArrayList<Board> selectList(int firstRow, int endRow){
		ArrayList<Board> mList = new ArrayList<Board>();
		String sql = "select *"+
				" from (select rownum rnum, b_id, title, context, viewCount,writer,mem_id"+
				" from (select rownum r, b_id, title, context, viewCount,writer,mem_id"+
				" from page_board"+
				" order by b_id desc))"+
				"where rnum between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setB_id(rs.getInt("b_id"));
				board.setTitle(rs.getString("title"));
				board.setContext(rs.getString("context"));
				board.setViewCount(rs.getInt("viewCount"));
				board.setWriter(rs.getString("writer"));
				board.setMem_id(rs.getString("mem_id"));
				mList.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

		return mList;
	}

}
