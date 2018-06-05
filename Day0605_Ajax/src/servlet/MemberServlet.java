package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.MemberDao;
import model.Member;

@WebServlet("/member")
public class MemberServlet extends HttpServlet{
	
	private MemberDao dao;
	public MemberServlet() {
		dao = MemberDao.getInstance();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		// ��û���� �ݽ� : command �Ķ���� �̿�
		String cmd = req.getParameter("command");
		
		if(cmd.equals("hello")) {	// command�� hello��  hello ��û
			Map<String, String[]> params = req.getParameterMap();
			for(String key : params.keySet()) {
				System.out.println(key+" : "+params.get(key));
			}
		}
		else if(cmd.equals("idCheck")) {
			String id = req.getParameter("id");
			Member mem = dao.selectOneById(id);
			
			String result = "";
			if(mem.getId() != null) {
				result = "\"���̵� �ߺ��Ǿ����ϴ�.\"}";
			}else {
				result = "\"��밡���� ���̵� �Դϴ�.\"}";
			}
			String res = "{\"res\" : "+result;
			resp.getWriter().println(res);
		}
		else if(cmd.equals("emailCheck")) {
			String email = req.getParameter("email");
			Member mem = dao.selectOneByEmail(email);
			
			String result = "";
			if(mem.getEmail() != null) {
				result = "\"�̹� ��ϵ� �̸��� �Դϴ�.\"}";
			}else {
				result = "\"��밡���� �̸��� �Դϴ�.\"}";
			}
			String res = "{\"res\" : "+result;
			resp.getWriter().println(res);
		}
		else if(cmd.equals("join")) {
			Member member = new Member(); 
			member.setId(req.getParameter("userid"));
			member.setEmail(req.getParameter("email"));
			member.setName(req.getParameter("name"));
			member.setPassword(req.getParameter("password"));
			
			boolean result = dao.addMember(member);
			String data="";
			if(result) {
				data = "{\"result\" : true}";
			}else {
				data = "{\"result\" : false}";
			}
			resp.getWriter().print(data);
		}
		else if(cmd.equals("memberList")) {
			List<Member> mList = dao.selectAll();
			
			// Gson : �ڹ� ����Ʈ�� json ���·� ���� �ٲ��ִ� ���̺귯��
			String result = new Gson().toJson(mList);	// ���� ����
			resp.getWriter().println(result);
		}
		else if(cmd.equals("delMember")) {
			String del_Id = req.getParameter("deleteId");
			boolean result = dao.delMember(del_Id);
			String data = "";
			if(result) {
				data = "{\"result\" : true}";
			}else {
				data = "{\"result\" : false}";
			}
			resp.getWriter().print(data);		
			
		}
		
	}
	
}
