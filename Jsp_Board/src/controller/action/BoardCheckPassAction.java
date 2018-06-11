package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String number = req.getParameter("num");
		String pass = req.getParameter("pass");
		
		BoardDao dao = BoardDaoImp.getInstance();
		Board board = dao.selectOne(number);
		String url = "";
		if(board.getPass().equals(pass)) {
			// 수정화면으로
			url = "jsp/checkSuccess.jsp";
		}
		else {
			// 비밀번호 틀림, 비밀번호 입력창으로 다시 이동
			url = "jsp/boardCheckPassword.jsp";
			req.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
		}
		req.getRequestDispatcher(url).forward(req, resp);
	}

}
