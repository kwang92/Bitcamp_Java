package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Member;

public class MemberDao {
	private static MemberDao dao;
	private Connection conn;
	
	private MemberDao() {
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
	public static MemberDao getInstance() {
		if(dao == null) {
			dao = new MemberDao();
		}
		return dao;
	}
	public boolean updateProfile(String id, String path) {
		String sql = "update page_member set img_path = ?"
				+ " where mem_id = '"+id+"'";
		PreparedStatement pstmt = null;
		System.out.println("dao update picture Ω√¿€");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, path);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateMember(Member member) {
		String sql = "update page_member set"
				+ " password = ?,"
				+ " name = ?,"
				+ " email = ?,"
				+ " picture = ?"
				+ " where mem_id = '"+member.getMem_id()+"'";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getProfile());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public Member selectOne(String id) {
		Member member = null;
		String sql = "select * from page_member where mem_id = '"+id+"'";
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				member = new Member(rs.getString("mem_id"),rs.getString("password"),rs.getString("name"),rs.getString("email"));
				if(rs.getString("img_path") != null) {
					member.setProfile(rs.getString("img_path"));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	public boolean addMember(Member member) {
		String sql = "insert into page_member(mem_id,password,name,email) values(?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMem_id());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
}
