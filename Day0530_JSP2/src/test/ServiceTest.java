package test;

import org.junit.Test;

import dao.MemberDAO;
import service.MemberService;

public class ServiceTest {
	// �׽�Ʈ�� �����ϴ� �޼ҵ带 ������ Ŭ����
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
