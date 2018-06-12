package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;

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
		
		String cmd = req.getParameter("cmd");
		if(cmd.equals("/")) {
			resp.sendRedirect("mainForm.jsp");
		}
		else if(cmd.equals("login")) {
			resp.sendRedirect("loginForm");
		}
		else if(cmd.equals("loginForm")) {
			req.getRequestDispatcher("loginForm.jsp").forward(req, resp);
		}
		else if(cmd.equals("loginCheck")) {	// Member �α��� üũ method
			String input_id = req.getParameter("id");
			String input_pwd = req.getParameter("pwd");

			int result = mService.loginCheck(input_id, input_pwd);

			if(result == 2) {	// �α��� ���� �� session�� id ���� �� mainForm���� �̵�
				Member current_Member = mService.getUserInfo(input_id);	
				current_Member.setTotalWrite(bService.countTotal(input_id));
				req.getSession().setAttribute("user", current_Member);
				System.out.println("�����α��� ����");
				resp.sendRedirect("boardList.jsp");
			}else if(result == 1) {
				req.getSession().setAttribute("reason", "���̵� �������� �ʽ��ϴ�.");
			}else {
				req.getSession().setAttribute("reason", "��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			}
		}
		else if(cmd.equals("mainForm")) {
			req.getRequestDispatcher("mainForm.jsp").forward(req, resp);
		}
		else if(cmd.equals("main")) {
			resp.sendRedirect("mainForm");
		}
		else if(cmd.equals("newJoin")) {
			Enumeration<String> names = req.getParameterNames();
			Member member = new Member();
			String email = "";
			while(names.hasMoreElements()) {
				String name = names.nextElement();
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
					email += req.getParameter(name);
					break;
				case "site":
					if(!name.equals("")) {
						email += req.getParameter(name);
					}
					break;
				}
			}
			member.setEmail(email);
			if(mService.join(member)) {
				System.out.println("���Լ���");
			}
			System.out.println("���Խ���");
			req.getRequestDispatcher("login").forward(req, resp);
		}
		else if(cmd.equals("newjoinForm")) {
			req.getRequestDispatcher("newJoin.jsp").forward(req, resp);
		}
		else if(cmd.equals("writePage")) {
			resp.sendRedirect("WriteBoard.jsp");
		}
		else if(cmd.equals("write")) {
			String title = req.getParameter("title");
			String context = req.getParameter("context");
			Board brd = new Board(title,context);
			Member mem = (Member)req.getSession().getAttribute("user");
			bService.writeBoard(brd, mem);
			resp.sendRedirect("boardList");
		}
		else if(cmd.equals("boardList")) {
			req.getRequestDispatcher("boardList.jsp").forward(req, resp);
		}

		else if(cmd.equals("reqList")) {

			List<Board> bList = bService.getAllBoards();
			String result = "";
			if(bList.size() > 0) {
				result = new Gson().toJson(bList);
				req.setAttribute("option", 0);
				
			}
			resp.getWriter().println(result);
		}
		else if(cmd.equals("optionList")) {
			List<Board> bList;
			String option = req.getParameter("option");
			String info = req.getParameter("info");

			if(option.equals("title")) {	// �������� �˻�
				bList = bService.getBoardByTitle(info);
			}
			else {	// �ۼ��ڷ� �˻�
				bList = bService.getBoardByName(info);
			}
			req.setAttribute("option", 1);
			String result = new Gson().toJson(bList);
			resp.getWriter().println(result);
		}
		else if(cmd.equals("logout")) {
			req.getSession().removeAttribute("user");
			req.getRequestDispatcher("main").forward(req, resp);
		}
		else if(cmd.equals("boardView")) {
			if(req.getParameter("option") == null) {
				return;
			}
			int op = Integer.parseInt(req.getParameter("option"));
			int count = Integer.parseInt(req.getParameter("cnt"));
			bService.updateView(op);
			
			Board board = bService.getOneBoard(op);
			
			req.setAttribute("board", board);
			req.getRequestDispatcher("board.jsp").forward(req, resp);
		}
		else if(cmd.equals("delBoard")) {
			String del_Id = req.getParameter("delId");
			if(del_Id == null) {
				return;
			}
			boolean result = bService.delBoard(Integer.parseInt(del_Id));
			String data = "";
			if(result) {
				data = "{\"result\" : true}";
			}else {
				data = "{\"result\" : false}";
			}
			resp.getWriter().print(data);
		}
		else if(cmd.equals("modify_fin")) {
			// �� ���� ���� ����
	//		List items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req); 
			System.out.println("�������� ����");
			String contentType = req.getContentType();
			System.out.println(contentType);
			if(contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
				Member m =(Member)req.getSession().getAttribute("user");
				Collection<Part> parts = req.getParts();
				mService.uploadPicture(parts,m.getMem_id());
			}
		}
		else if(cmd.equals("checkInput")) {
			String id = req.getParameter("data");
			id = id.substring(2, id.length());
			String result = "";
			if(mService.getUserInfo(id) == null) {	// ���԰����� ���̵�� true ��ȯ
				result = "{\"res\":true}";
			}else {	// �ߺ��� ���̵�� false ��ȯ
				result = "{\"res\":false}";
			}
			resp.getWriter().flush();
			resp.getWriter().println(result);
		}
		
	}

}
