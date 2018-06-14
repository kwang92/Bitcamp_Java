package service;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.http.Part;

import dao.MemberDao;
import model.Member;

public class MemberService {
	private static MemberService service;
	private MemberDao dao;
	private final String PATH = "C:\\user_pic\\";
	private MemberService() {
		dao = MemberDao.getInstance();
	}
	public static MemberService getInstance() {
		service = new MemberService();
		
		return service;
	}
	public int loginCheck(String id, String pwd) {
		// 로그인 성공 시 2, 비밀번호 틀릴 시 1, 아이디 틀릴 시 0 return
		Member member;
		if( (member = dao.selectOne(id) ) != null ) {	// id로 select 한 Member colum이 존재함
			if((member.getPassword()).equals(pwd)) {
				return 2;
			}
			return 1;
		}
		return 0;
	}
	public String uploadPicture(Collection<Part> parts, String id) {
		String path = null;
		for(Part part : parts) {
			if(part.getHeader("Content-Disposition").contains("filename=")) {
				String fileName = part.getSubmittedFileName();
				String fName = fileName;
				
				if(part.getSize() > 0) {
					try {
						part.write(PATH+fName);				
						dao.updateProfile(id, fName);
						return fName;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		return path;
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
	public boolean infoModify(Member member) {
		if(dao.updateMember(member)) {
			return true;
		}
		return false;
	}
}
