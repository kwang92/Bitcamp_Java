package dao;

import model.Member;

public interface MemberDao {
	public int insertMember(Member member);
	public int deleteMember(String id);
	public Member selectOne(String id);
	
}
