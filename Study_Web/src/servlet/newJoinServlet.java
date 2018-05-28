package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDAO;

@WebServlet("/newJoin")
public class newJoinServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO dao = new UserDAO();
		Enumeration<String> names = req.getParameterNames();
		User usr = new User();
		String birth = "";
		
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println(name);
			switch(name) {
			case "id":
				usr.setUserid(req.getParameter(name));
				break;
			case "pwd":
				usr.setUserpwd(req.getParameter(name));
				break;
			case "name":
				usr.setName(req.getParameter(name));
				break;
			case "check_gender":
				usr.setGender(req.getParameter(name));
				break;
			case "year": case "month": case "day":
				birth += req.getParameter(name)+"/";
				usr.setBirth(birth);
				break;
			}
		}
		boolean isIn = dao.addUser(usr);
		String res = "FAIL";
		if(isIn) {
			res = "SUC";
		}
		req.setAttribute("join_res", res);
		RequestDispatcher dp = req.getRequestDispatcher("newJoin.jsp");
		dp.forward(req, resp);
	}
	
}
