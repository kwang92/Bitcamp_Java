package service;

import java.util.ArrayList;

import dao.MessageDao;
import model.Message;

public class MessageService {
	private MessageDao dao;
	public MessageService() {
		dao = new MessageDao();
	}
	public boolean writeMsg(Message msg) {
		System.out.println("service write메소드 in");
		if(dao.sendMsg(msg)) {
			System.out.println("service dao insert 성공");
			return true;
		}
		return false;
	}
	public ArrayList<Message> getAllMsg(){
		ArrayList<Message> msgs = dao.getMsgs();
		
		return msgs;
	}
}
