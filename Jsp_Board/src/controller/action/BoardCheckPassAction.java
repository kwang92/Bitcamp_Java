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
			// ����ȭ������
			url = "jsp/checkSuccess.jsp";
		}
		else {
			// ��й�ȣ Ʋ��, ��й�ȣ �Է�â���� �ٽ� �̵�
			url = "jsp/boardCheckPassword.jsp";
			req.setAttribute("msg", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
		req.getRequestDispatcher(url).forward(req, resp);
	}

}
