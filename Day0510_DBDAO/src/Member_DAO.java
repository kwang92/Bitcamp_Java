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
		String sql = "insert into Member (num,id,pw,name,e_mail) values(member_seq.nextval,?,?,?,?)";
	
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPw());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getE_Mail());			
			pstmt.executeUpdate();
			System.out.println("execute 완료");
			
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
				",reg_date = ?"+
				" where num = "+mem.getNum();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem.getNum());
			pstmt.setString(2, mem.getId());
			pstmt.setString(3, mem.getPw());
			pstmt.setString(4, mem.getName());
			pstmt.setString(5, mem.getE_Mail());
			pstmt.setTimestamp(6, mem.getReg_Timestamp());
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
						rs.getString("e_mail"),rs.getTimestamp("reg_date"));
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
						,rs.getString("e_mail"), rs.getTimestamp("reg_date")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return mem_List;
	}
	public boolean joinUser(Member mem) {
		String sql = "select id from member where id = '"+mem.getId()+"'";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("중복된 아이디 입니다.");
				return false;
			}
			insertMember(mem);
			System.out.println("가입성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	public boolean checkUser(String id, String pw) {
		String sql = "select * from member where id = '"+id+"'";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				if(rs.getString("pw").equals(pw)) {
					return true;
				}else {
					System.out.println("비밀번호가 틀렸습니다.");
					return false;
				}
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("아이디가 없습니다.");
		return false;
	}
}