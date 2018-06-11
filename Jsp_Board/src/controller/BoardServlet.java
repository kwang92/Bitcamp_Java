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
		// 요청별로 새로운 클래스를 만들어서 실행
		// ActionFactory : 실제 요청을 처리할 클래스의 객체를 만들어주는 역할
		String command = req.getParameter("command");
		
		Action action = BoardActionFactory.getAction(command);	// 요청에 맞는 객체를 ActionFactory로 부터 받아온다.
		action.execute(req, resp);	// command에 맞는 해당 객체의 execute를 실행
	}
}
