package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Message;
import service.MessageService;

public class MessageServlet extends HttpServlet{
	private MessageService service;
	private ArrayList<Message> msgList;
	private int count;
	public MessageServlet() {
		service = new MessageService();
		msgList = service.getAllMsg();
		if(msgList.size() > 0) {
			count = msgList.get(msgList.size()-1).getId();
		}else {
			count = 0;
		}
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
		if(uri.equals(path+"/messageList")) {
			req.getSession().setAttribute("msgs", msgList);
			req.getRequestDispatcher("messageList.jsp").forward(req, resp);
		}
		else if(uri.equals(path+"/write")) {
			Message msg = new Message(req.getParameter("password"), req.getParameter("name"), req.getParameter("context"));
			if(service.writeMsg(msg)) {
				msgList.add(msg);
				
				if(msgList.size() != 1) {
					msgList.get(msgList.size()-1).setId(++count);
				}
				req.getSession().setAttribute("msgs", msgList);
				resp.sendRedirect("messageList");
			}
		}
	}
}
