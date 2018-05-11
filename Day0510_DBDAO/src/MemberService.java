
public class MemberService{
	private Member_DAO dao;
	public MemberService(Member_DAO dao) {
		this.dao = dao;
	}
	public boolean login(String id, String pw) {
		return dao.checkUser(id, pw);
	}
}