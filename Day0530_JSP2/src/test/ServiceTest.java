package test;

import org.junit.Test;

import dao.MemberDAO;
import service.MemberService;

public class ServiceTest {
	// 테스트를 수행하는 메소드를 가지는 클래스
	private MemberService service;
	private MemberDAO dao;
	@Test
	public void testService() {
		service = new MemberService();
		
	}
	
	@Test
	public void daoTest() {
		dao = new MemberDAO();
		
	}
}
