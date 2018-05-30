package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Board;

@WebServlet("/board")
public class BoardServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("writer");
		String pass = req.getParameter("pwd");
		String email = req.getParameter("email");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		Board brd = new Board(name, pass, email, title, content);
		req.setAttribute("board", brd);
		RequestDispatcher dispatcher = req.getRequestDispatcher("boardInfo.jsp");
		dispatcher.forward(req, resp);
	}
	
}
