package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Board;
import model.Member;
import service.BoardService;
import service.MemberService;

public class PageServlet extends HttpServlet{
	private MemberService mService;
	private BoardService bService;
	
	public PageServlet() {
		mService = MemberService.getInstance();
		bService = BoardService.getInstance();
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
		String url = req.getRequestURI();
		String path = req.getContextPath();
		
		if(url.equals(path+"/login")) {
			resp.sendRedirect("loginForm");
		}
		else if(url.equals(path+"/loginForm")) {
			req.getRequestDispatcher("loginForm.jsp").forward(req, resp);
		}
		else if(url.equals(path+"/loginCheck")) {	// Member �α��� üũ method
			String input_id = req.getParameter("id");
			String input_pwd = req.getParameter("pwd");
			
			int result = mService.loginCheck(input_id, input_pwd);
			
			if(result == 2) {	// �α��� ���� �� session�� id ���� �� mainForm���� �̵�
				Member current_Member = mService.getUserInfo(input_id);	
				req.getSession().setAttribute("user", current_Member);
				resp.sendRedirect("main");
			}else if(result == 1) {
				req.getSession().setAttribute("reason", "���̵� �������� �ʽ��ϴ�.");
			}else {
				req.getSession().setAttribute("reason", "��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			}
		}
		else if(url.equals(path+"/mainForm")) {
			req.getRequestDispatcher("mainForm.jsp").forward(req, resp);
		}
		else if(url.equals(path+"/main")) {
			resp.sendRedirect("mainForm");
		}
		else if(url.equals(path+"/newJoin")) {
			Enumeration<String> names = req.getParameterNames();
			Member member = new Member();
			String birth = "";
			
			while(names.hasMoreElements()) {
				String name = names.nextElement();
				System.out.println(name);
				switch(name) {
				case "id":
					member.setMem_id(req.getParameter(name));
					break;
				case "pwd":
					member.setPassword(req.getParameter(name));
					break;
				case "name":
					member.setName(req.getParameter(name));
					break;
				case "mail":
					member.setEmail(req.getParameter(name));
					break;
				}
			}
			if(mService.join(member)) {
				System.out.println("���Լ���");
				return;
			}
			System.out.println("���Խ���");
		}
		else if(url.equals(path+"/newjoinForm")) {
			req.getRequestDispatcher("newJoin.jsp").forward(req, resp);
		}
		else if(url.equals(path+"/write")) {
			String title = req.getParameter("title");
			String context = req.getParameter("context");
			Board brd = new Board(title,context);
			Member mem = (Member)req.getSession().getAttribute("user");
			bService.writeBoard(brd, mem);
			resp.sendRedirect("boardList");
		}
		else if(url.equals(path+"/boardList")) {
			req.getRequestDispatcher("BoardList.jsp").forward(req, resp);
		}
		else if(url.equals(path+"/goBack")) {
			
		}
	}
	
}
