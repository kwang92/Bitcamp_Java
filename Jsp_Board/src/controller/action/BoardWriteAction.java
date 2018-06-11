package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDao dao = BoardDaoImp.getInstance();
		Board board = new Board();
		
		board.setContent(req.getParameter("content"));
		board.setTitle(req.getParameter("title"));
		board.setEmail(req.getParameter("email"));
		board.setPass(req.getParameter("pass"));
		board.setName(req.getParameter("name"));
		
		int result = dao.insertBoard(board);
		
		if(result > 0) {
			req.setAttribute("msg", "등록완료");
		}
		else {
			req.setAttribute("msg", "등록 중 오류가 발생하였습니다.");
		}
		req.setAttribute("url", "boardList");
		req.getRequestDispatcher("jsp/result.jsp").forward(req, resp);
	}

}
