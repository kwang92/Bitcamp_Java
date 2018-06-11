package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "";
		BoardDao dao = BoardDaoImp.getInstance();
		Board board = new Board();
		board.setTitle(req.getParameter("title"));
		board.setName(req.getParameter("name"));
		board.setPass(req.getParameter("pass"));
		board.setEmail(req.getParameter("email"));
		board.setContent(req.getParameter("content"));
		board.setNum(Integer.parseInt(req.getParameter("num")));
		if(dao.updateBoard(board) > 0) {
			req.setAttribute("board", board);
			url = "/jsp/boardView.jsp";
		}else {
			System.out.println("update ½ÇÆÐ");
		}
		
		req.getRequestDispatcher(url).forward(req, resp);
	}

}
