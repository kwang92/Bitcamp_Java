package service;

import java.util.ArrayList;

import dao.MemberDAO;
import model.Member;

public class MemberService {
	// login, logout, join(Member), modify(Member) ������ Ŭ����
	private MemberDAO dao;
	
	public MemberService() {
		dao = new MemberDAO();
	}
	public String login(String id, String pwd) {
		Member mem = dao.selectOne(id);
		String reason = "";
		if(mem != null) {	// id�� �ش��ϴ� ����� ���� �� ��
			if(mem.getPw().equals(pwd)) {
				reason = "SUC";
			}else {	// id�� ��ġ�ؼ� select�� �ؿ����� select �� ����� ��й�ȣ�� input�� ��й�ȣ�� Ʋ�� ��
				reason = "��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
			}
		}else {	// id�� �ش��ϴ� select�� return ���� 0�� �� ��
			reason = "���̵� �������� �ʽ��ϴ�.";
		}
		return reason;
	}
	public boolean del(String nowId,String inPw) {
		if(dao.deleteUser(nowId, inPw)) {
			return true;
		}
		return false;
	}
	public boolean join(Member mem) {
		boolean work = true;
		
		if(dao.selectOne(mem.getId()) != null) {
			work = false;
		}
		else{
			if(dao.addMember(mem)) {
				work = true;
			}
		}		
		return work;
	}
	public Member getMember(String id) {
		return dao.selectOne(id);
	}
	public boolean modifyMem(Member member) {
		
		
		return false;
	}
	public ArrayList<Member> showAllMembers() {
		ArrayList<Member> list = dao.selectAll();
		return list;
	}
}
