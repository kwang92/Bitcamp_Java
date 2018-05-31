package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import service.MemberService;

public class MemberServlet extends HttpServlet{
	
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
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();

		if(uri.equals(contextPath+"/login")) {
			MemberService ms = new MemberService();
			String in_Id = req.getParameter("id");
			String in_Pwd = req.getParameter("pwd");

			String result = ms.login(in_Id, in_Pwd); 
			if(result.equals("SUC")) {
				req.getSession().setAttribute("id", in_Id);
				resp.sendRedirect("main");
			} else {
				req.getSession().setAttribute("reason", result);
				resp.sendRedirect("loginForm");
			}
			
		}
		else if(uri.equals(contextPath+"/addUser")){
			MemberService ms = new MemberService();
			Enumeration<String> names = req.getParameterNames();
			Member mem = new Member();
			
			while(names.hasMoreElements()) {
				String name = names.nextElement();
				System.out.println(name);
				switch(name) {
				case "id":
					mem.setId(req.getParameter(name));
					break;
				case "pwd":
					mem.setPw(req.getParameter(name));
					break;
				case "name":
					mem.setName(req.getParameter(name));
					break;
				case "email":
					mem.setEmail(req.getParameter(name));
					break;
				}
			}
			
			String target;
			if(ms.join(mem)) {
				System.out.println("서블릿 : 가입성공");
				target = "loginForm";
//				req.getSession().setAttribute("id", mem.getId());
			} else {
				System.out.println("서블릿 : 가입실패");
				target = "joinForm";
			}
			resp.sendRedirect(target);
		}
		else if(uri.equals(contextPath+"/memberlist")){	// memberList페이지 요청이 들어왔을 때
			MemberService ms = new MemberService();
			req.getSession().setAttribute("members", ms.showAllMembers());
			resp.sendRedirect("memberListForm");
		}
		else if(uri.equals(contextPath+"/modify")){	// memberList페이지 요청이 들어왔을 때
			MemberService ms = new MemberService();
			Member member = ms.getMember((String)req.getSession().getAttribute("id"));
			if(member != null) {
				req.getSession().setAttribute("member", member);
				resp.sendRedirect("modifyForm");
			}
		}
		else if(uri.equals(contextPath+"/modifyCom")){	// memberList페이지 요청이 들어왔을 때
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			String mail = req.getParameter("mail");
			
			MemberService ms = new MemberService();
			Member member = ms.getMember((String)req.getSession().getAttribute("id"));
			member.setPw(pwd);
			member.setName(name);
			member.setEmail(mail);
			if(ms.modifyMem(member)) {
				resp.sendRedirect("main");
				return;
			}
			resp.sendRedirect("modify");
		}
		else if(uri.equals(contextPath+"/logout")){	// memberList페이지 요청이 들어왔을 때
			req.getSession().removeAttribute("id");
			resp.sendRedirect("loginForm");
		}
		else if(uri.equals(contextPath+"/outjoin")){	// memberList페이지 요청이 들어왔을 때
			MemberService ms = new MemberService();
			ms.del((String)req.getSession().getAttribute("id"));
			req.getSession().removeAttribute("pwd");
			req.getSession().removeAttribute("id");
			resp.sendRedirect("loginForm");
		}
		else if(uri.equals(contextPath+"/stepback")){	// memberList페이지 요청이 들어왔을 때
			resp.sendRedirect("main");
		}
		else if(uri.equals(contextPath+"/main")) {
			resp.sendRedirect("mainForm");
		}
		else if(uri.equals(contextPath+"/mainForm")){	// memberList페이지 요청이 들어왔을 때
			if(req.getSession().getAttribute("id") != null) {
				req.getRequestDispatcher("main.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("loginForm.jsp").forward(req, resp);
			}
			
		}
		else if(uri.equals(contextPath+"/loginForm")){	// loginForm페이지 요청이 들어왔을 때
			req.getRequestDispatcher("loginForm.jsp").forward(req, resp);
		}
		else if(uri.equals(contextPath+"/newjoinForm")){	// newJoin페이지 요청이 들어왔을 때
			req.getRequestDispatcher("joinForm.jsp").forward(req, resp);
		}
		else if(uri.equals(contextPath+"/memberListForm")){	// memberList페이지 요청이 들어왔을 때
			if(req.getSession().getAttribute("id") != null) {
				req.getRequestDispatcher("memberList.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("loginForm.jsp").forward(req, resp);
			}
		}
		else if(uri.equals(contextPath+"/modifyForm")){	// newJoin페이지 요청이 들어왔을 때
			req.getRequestDispatcher("modifyForm.jsp").forward(req, resp);
		}
		
	}
	
}
