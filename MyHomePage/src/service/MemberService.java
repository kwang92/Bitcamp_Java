package service;

import dao.MemberDao;
import model.Member;

public class MemberService {
	private static MemberService service;
	private MemberDao dao;
	private MemberService() {
		dao = MemberDao.getInstance();
	}
	public static MemberService getInstance() {
		service = new MemberService();
		
		return service;
	}
	public int loginCheck(String id, String pwd) {
		// �α��� ���� �� 2, ��й�ȣ Ʋ�� �� 1, ���̵� Ʋ�� �� 0 return
		Member member;
		if( (member = dao.selectOne(id) ) != null ) {	// id�� select �� Member colum�� ������
			if((member.getPassword()).equals(pwd)) {
				return 2;
			}
			return 1;
		}
		return 0;
	}
	public Member getUserInfo(String id) {
		Member member = dao.selectOne(id);
		return member;
	}
	public boolean join(Member member) {
		if(dao.addMember(member)) {
			return true;
		}
		
		return false;
	}
}
