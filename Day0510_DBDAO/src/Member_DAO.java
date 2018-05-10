import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Member_DAO {
	private Connection conn;
	
	public Member_DAO() {
		try {
			conn =  GetConnection.GetConnection();
			System.out.println("연결완료");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertMember(Member mem) {
		String sql = "insert into Member (num,id,pw,name,e_mail) values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem.getNum());
			pstmt.setString(2, mem.getId());
			pstmt.setString(3, mem.getPw());
			pstmt.setString(4, mem.getName());
			pstmt.setString(5, mem.getE_Mail());
			
			pstmt.executeUpdate();
			System.out.println("execute 완료");
			Member.increaseMember();
		} catch (SQLIntegrityConstraintViolationException e) { 
			System.out.println("제약조건 위배");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateMember(Member mem) {
		String sql = "update member set"+
					" num = ?"+
					",id = ?"+
					",pw = ?"+
					",name = ?"+
					",e_mail = ? "+
					"where num = "+mem.getNum();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem.getNum());
			pstmt.setString(2, mem.getId());
			pstmt.setString(3, mem.getPw());
			pstmt.setString(4, mem.getName());
			pstmt.setString(5, mem.getE_Mail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteMember(int num) {
		String sql = "delete from MEMBER"+
					" where num = "+num;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			Member.decreaseMember();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Member selectOne(int num) {
		Member mem = null;
		String sql = "select * from Member"+
					" where num = "+num;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				mem = new Member(rs.getInt("num"),rs.getString("id"),rs.getString("pw"),rs.getString("name"),
									rs.getString("e_mail"),rs.getString("reg_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mem;
	}
	public List<Member> selectAll(){
		List<Member> mem_List = new ArrayList<Member>();
		String sql = "select * from MEMBER";
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				mem_List.add(new Member(rs.getInt("num"),rs.getString("id")
										,rs.getString("pw"),rs.getString("name")
										,rs.getString("e_mail"), rs.getString("reg_date")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return mem_List;
	}
}
