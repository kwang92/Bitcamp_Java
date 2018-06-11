package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String url = req.getRequestURI();
		String path = req.getContextPath();

		if(url.equals(path+"/")) {
			resp.sendRedirect("mainForm.jsp");
		}
		else if(url.equals(path+"/login")) {
			resp.sendRedirect("loginForm");
		}
		else if(url.equals(path+"/loginForm")) {
			req.getRequestDispatcher("loginForm.jsp").forward(req, resp);
		}
		else if(url.equals(path+"/loginCheck")) {	// Member 로그인 체크 method
			String input_id = req.getParameter("id");
			String input_pwd = req.getParameter("pwd");

			int result = mService.loginCheck(input_id, input_pwd);

			if(result == 2) {	// 로그인 성공 시 session에 id 저장 후 mainForm으로 이동
				Member current_Member = mService.getUserInfo(input_id);	
				current_Member.setTotalWrite(bService.countTotal(input_id));
				req.getSession().setAttribute("user", current_Member);
				resp.sendRedirect("boardList.jsp");
			}else if(result == 1) {
				req.getSession().setAttribute("reason", "아이디가 존재하지 않습니다.");
			}else {
				req.getSession().setAttribute("reason", "비밀번호가 틀렸습니다.");
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
			String email = "";
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
				System.out.println("가입성공");
			}
			System.out.println("가입실패");
			req.getRequestDispatcher("login").forward(req, resp);
		}
		else if(url.equals(path+"/newjoinForm")) {
			req.getRequestDispatcher("newJoin.jsp").forward(req, resp);
		}
		else if(url.equals(path+"/writePage")) {
			resp.sendRedirect("WriteBoard.jsp");
		}
		else if(url.equals(path+"/write")) {
			String title = req.getParameter("title");
			String context = req.getParameter("context");
			Board brd = new Board(title,context);
			Member mem = (Member)req.getSession().getAttribute("user");
			System.out.println("들어온 이름 "+mem.getName());
			bService.writeBoard(brd, mem);
			resp.sendRedirect("boardList");
		}
		else if(url.equals(path+"/boardList")) {
			req.getRequestDispatcher("boardList.jsp").forward(req, resp);
		}

		else if(url.equals(path+"/reqList")) {

			List<Board> bList = bService.getAllBoards();
			String result = "";
			if(bList.size() > 0) {
				System.out.println(bList.get(0).getWriter());
				result = new Gson().toJson(bList);
				req.setAttribute("option", 0);
				
			}
			resp.getWriter().println(result);
		}
		else if(url.equals(path+"/optionList")) {
			List<Board> bList;
			String option = req.getParameter("option");
			String info = req.getParameter("info");

			if(option.equals("title")) {	// 제목으로 검색
				bList = bService.getBoardByTitle(info);
			}
			else {	// 작성자로 검색
				bList = bService.getBoardByName(info);
			}
			req.setAttribute("option", 1);
			String result = new Gson().toJson(bList);
			resp.getWriter().println(result);
		}
		else if(url.equals(path+"/logout")) {
			System.out.println("로그아웃 요청받음");
			req.getSession().removeAttribute("user");
			req.getRequestDispatcher("main").forward(req, resp);
		}
		else if(url.equals(path+"/boardView")) {
			if(req.getParameter("option") == null) {
				return;
			}
			int op = Integer.parseInt(req.getParameter("option"));

			Board board = bService.getOneBoard(op);
			req.setAttribute("board", board);
			req.getRequestDispatcher("board.jsp").forward(req, resp);
		}
		else if(url.equals(path+"/delBoard")) {
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
		else if(url.equals(path+"/modify_fin")) {
			Member mem = (Member)req.getSession().getAttribute("user");
			if(!mem.getName().equals(req.getParameter("name"))) {
				mem.setName(req.getParameter("name"));
			}
			if(!mem.getPassword().equals(req.getParameter("pass"))) {
				mem.setPassword(req.getParameter("pass"));
			}
			if(mem.getEmail() != null && !mem.getEmail().equals(req.getParameter("email"))) {
				mem.setEmail(req.getParameter("email"));
			}
			System.out.println(req.getParameter("picture"));
			if(mem.getProfile() != null && !mem.getProfile().equals(req.getParameter("picture").getBytes())) {
				mem.setProfile(req.getParameter("picture").getBytes());
			}
			mService.infoModify(mem);
		}

	}

}
