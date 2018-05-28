package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDAO;

@WebServlet("/login")
public class loginServlet extends HttpServlet{
	private UserDAO user_Dao;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		user_Dao = new UserDAO();
		String id = req.getParameter("user_id");
		String pwd = req.getParameter("user_pwd");
		User usr = new User(id, pwd);
		int check = user_Dao.checkUser(usr);
		// check 0 아이디틀림, 1 비번틀림, 2 성공
		RequestDispatcher dispatcher;
		String next_Page = "index.jsp";
	 	if(check == 2){
	 		next_Page = "loginSuccess.jsp";	
	 	} else if (check == 1){
	 		req.setAttribute("reason", "비밀번호가 틀렸습니다.");
	 	} else{
	 		req.setAttribute("reason", "아이디가 존재하지 않습니다.");
	 	}
	 	dispatcher = req.getRequestDispatcher(next_Page);	// 이동할 페이지를 RequestDispatcher에 저장하고
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	
	
	
}
