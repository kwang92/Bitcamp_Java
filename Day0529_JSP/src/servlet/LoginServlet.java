package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	String id = "rkm92";
	String pwd = "rhkd12";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String in_Id = req.getParameter("id");
		String in_Pwd = req.getParameter("pwd");
	
		if(in_Id.equals(id)) {
			if(in_Pwd.equals(pwd)) {
				req.getSession().setAttribute("user_id", in_Id);
				req.getSession().setAttribute("user_pwd", in_Pwd);
				resp.sendRedirect("main");
				return;
			}
		}
		resp.sendRedirect("04loginForm.jsp");
		
	}
}
