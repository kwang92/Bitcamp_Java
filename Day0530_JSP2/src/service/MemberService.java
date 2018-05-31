package service;

import java.util.ArrayList;

import dao.MemberDAO;
import model.Member;

public class MemberService {
	// login, logout, join(Member), modify(Member) 구현할 클래스
	private MemberDAO dao;

	public MemberService() {
		dao = new MemberDAO();
	}
	public String login(String id, String pwd) {
		Member mem = dao.selectOne(id);
		String reason = "";
		if(mem != null) {	// id에 해당하는 멤버가 존재 할 때
			if(mem.getPw().equals(pwd)) {
				reason = "SUC";
			}else {	// id가 일치해서 select을 해왔지만 select 된 멤버의 비밀번호가 input의 비밀번호와 틀릴 때
				reason = "비밀번호가 일치하지 않습니다.";
			}
		}else {	// id에 해당하는 select의 return 값이 0개 일 때
			reason = "아이디가 존재하지 않습니다.";
		}
		return reason;
	}
	public boolean del(String nowId) {
		if(dao.deleteUser(nowId)) {
			return true;
		}
		return false;
	}
	public boolean join(Member mem) {
		boolean work = false;

		if(dao.addMember(mem)) {
			System.out.println("서비스에서 이프문");
			work = true;
		}

		return work;
	}
	public Member getMember(String id) {
		return dao.selectOne(id);
	}
	public boolean modifyMem(Member member) {
		if(dao.updateMember(member)) {
			return true;
		}

		return false;
	}
	public ArrayList<Member> showAllMembers() {
		ArrayList<Member> list = dao.selectAll();
		return list;
	}
}
