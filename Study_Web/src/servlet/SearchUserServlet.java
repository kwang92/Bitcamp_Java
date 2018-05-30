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

@WebServlet("/search")
public class SearchUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("search");
		UserDAO dao = new UserDAO();
		String current = (String)req.getSession().getAttribute("id");
		User usr = dao.selectUser(current);
		req.getSession().setAttribute("data", usr);
		resp.sendRedirect("myInfo.jsp");
	}

}
