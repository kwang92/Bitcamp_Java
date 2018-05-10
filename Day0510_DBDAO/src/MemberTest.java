
public class MemberTest {
	static Member_DAO md = new Member_DAO();
	public static void main(String[] args) {
		md.insertMember(new Member(Member.getMemberCnt(),"hong123","1234","홍길동","hong@daum.net"));	// 홍길동 추가
		System.out.println("추가완료");
		md.insertMember(new Member(Member.getMemberCnt(),"sinsa11","8520","신사임당","sinsa@gmail.com"));	// 신사임당 추가
		System.out.println("추가완료");
		md.insertMember(new Member(Member.getMemberCnt(),"turtle","2222","이순신","soon@gmail.com"));	// 이순신 추가
		System.out.println("추가완료");
		md.insertMember(new Member(Member.getMemberCnt(),"turi","5555","우투리","wooturi@naver.com"));	// 이순신 추가
		System.out.println("추가완료");
		md.deleteMember(2);
		System.out.println("삭제완료");
		
		Member m = md.selectOne(3);	// 신사임당을 가져와서 저장하고
		m.setPw("7777");	// 비번을 7777로 바꾸고
		md.updateMember(m);	// 신사임당 정보 업데이트
		System.out.println("변경완료");
		displayAll();
		
		
	}
	public static void displayAll() {
		for(Member m : md.selectAll()) {
			System.out.println(m);
		}
	}
}
