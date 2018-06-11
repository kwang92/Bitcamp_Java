package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;

@WebServlet("/board")
public class BoardServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}
	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		// ��û���� ���ο� Ŭ������ ���� ����
		// ActionFactory : ���� ��û�� ó���� Ŭ������ ��ü�� ������ִ� ����
		String command = req.getParameter("command");
		
		Action action = BoardActionFactory.getAction(command);	// ��û�� �´� ��ü�� ActionFactory�� ���� �޾ƿ´�.
		action.execute(req, resp);	// command�� �´� �ش� ��ü�� execute�� ����
	}
}
