package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Message;
import service.MessageService;

public class MessageServlet extends HttpServlet{
	private MessageService service;
	public MessageServlet() {
		service = MessageService.getInstance();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}
	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String path = req.getContextPath();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		/*
		if(uri.equals(path+"/messageList")) {
			ArrayList<Message> msgList = service.getAllMsg();
			req.setAttribute("msgs", msgList);
			req.getRequestDispatcher("messageList.jsp").forward(req, resp);
		}*/
		if(uri.equals(path+"/messageList")) {
			int pageNumber = 1;
			String strPageNumber = req.getParameter("page");
			
			if(strPageNumber != null) {
				pageNumber = Integer.parseInt(strPageNumber);
			}
			//페이지 네비게이션 출력을 위한 정보를 전달
			Map<String, Object> viewData 
			= service.getMessageList(pageNumber);
			
			req.setAttribute("viewData",viewData);
			
			req.getRequestDispatcher("messageList.jsp").forward(req, resp);
		}
		else if(uri.equals(path+"/write")) {
			Message msg = new Message(req.getParameter("password"), req.getParameter("name"), req.getParameter("context"));
			if(service.writeMsg(msg)) {
				resp.sendRedirect("messageList");
			}
		}
		else if(uri.equals(path+"/del")) {
			int id = Integer.parseInt(req.getParameter("id"));
			String pwd = req.getParameter("pwd");
			service.delText(id, pwd);
			resp.sendRedirect("messageList");
		}
	}
}
