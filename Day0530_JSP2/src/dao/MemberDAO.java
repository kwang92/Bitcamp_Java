package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Member;

public class MemberDAO {
	private Connection conn;

	public MemberDAO() {
		try {
			this.conn = ConnectionProvider.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// insert, update, delete, select, selectAll 구현
	public boolean addMember(Member m) {
		String sql = "insert into member_table (memid, mempw, memname, mememail) values(?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPw());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.executeQuery();
			conn.commit();
			return true;
			// util 의 Date형식을 sql 의 Date형식으로 변환
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
	}
	public boolean deleteUser(String id) {
		String sql = "delete from member_table where memid = '"+id+"'";
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
	
	public boolean updateMember(Member m) {
		String sql = "update member_table set mempw = ?"
										+", memname = ?"
										+", mememail = ?"
										+" where memid = '"+m.getId()+"'"; 
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getPw());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getEmail());
			pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public Member selectOne(String id) {
		Member m = null;
		String sql = "select * from member_table where memid = '"+id+"'";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				m = new Member(rs.getString("memid"),rs.getString("mempw"),rs.getString("memname"),
								rs.getString("mememail"),rs.getDate("regdate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	public ArrayList<Member> selectAll(){
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = "select * from member_table";
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Member member = new Member(rs.getString("memid"),rs.getString("mempw"),rs.getString("memname"),
						rs.getString("mememail"));
				member.setRegDate(rs.getDate("regdate"));
				list.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
