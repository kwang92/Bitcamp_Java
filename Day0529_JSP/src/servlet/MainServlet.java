package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("user_id") != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("04main.jsp");
			dispatcher.forward(req, resp);
		}else {
			resp.sendRedirect("04loginForm.jsp");
		}
	}
}
