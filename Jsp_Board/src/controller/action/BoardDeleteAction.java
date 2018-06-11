package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardDao dao = BoardDaoImp.getInstance();
		int result = dao.deleteBoard(Integer.parseInt(req.getParameter("num")));
		String url = "jsp/result.jsp";
		if(result > 0) {
			req.setAttribute("msg", "삭제완료");
		}else {
			req.setAttribute("msg", "삭제실패");
		}
		req.setAttribute("url", "boardList");
		req.getRequestDispatcher(url).forward(req, resp);
	}

}
