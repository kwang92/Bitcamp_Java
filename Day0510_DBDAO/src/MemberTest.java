import java.sql.Timestamp;

public class MemberTest {
	static Member_DAO md = new Member_DAO();
	public static void main(String[] args) {
		
//		md.insertMember(new Member("hong123","1234","홍길동","hong@daum.net"));	// 홍길동 추가
		md.joinUser(new Member("hwang","1234","황사","send@daum.net"));
//		md.insertMember(new Member("sinsa11","8520","신사임당","sinsa@gmail.com"));	// 신사임당 추가
//		System.out.println("추가완료");
//		md.insertMember(new Member("turtle","2222","이순신","soon@gmail.com"));	// 이순신 추가
//		System.out.println("추가완료");
//		md.insertMember(new Member("turi","5555","우투리","wooturi@naver.com"));	// 이순신 추가
//		System.out.println("추가완료");
//		md.deleteMember(2);
//		System.out.println("삭제완료");
		
		/*
		Member_DAO dao = new Member_DAO();
		MemberService ms = new MemberService(dao);
		if(ms.login("awet", "1123")) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}*/
	}
}