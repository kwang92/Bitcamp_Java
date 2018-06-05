package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.MessageDao;
import model.Message;

public class MessageService {
	private MessageDao dao;
	private static MessageService service;
	private static final int NUM_OF_MESSAGE_PER_PAGE = 5;
	private static final int NUM_OF_NAVI_PAGE = 5;
	private MessageService() {
		dao = MessageDao.getInstance();	// 팩토리 메소드
	}
	public static MessageService getInstance() {
		service = new MessageService();
		return service;
	}
	public boolean writeMsg(Message msg) {
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
	public boolean delText(int id, String pwd) {
		if(dao.deleteMsg(id, pwd)) {
			return true;
		}		
		return false;
	}
	public Map<String,Object> getMessageList(int pageNumber) {
		// 현재 페이지에 표시될 메시지 목록 가져오기
		// 화면에 표시될 네비게이션의 정보를 계산 및 생성
		Map<String, Object> viewData = new HashMap<String,Object>();
		int firstRow = 0;
		int endRow = 0; 
		int totalCount = 0;	// 한 네비게이션의 시작페이지 부터 끝 페이지
		
		totalCount = dao.selectCount();
		firstRow = (pageNumber-1)*NUM_OF_MESSAGE_PER_PAGE +1;
		endRow = pageNumber*NUM_OF_MESSAGE_PER_PAGE;
		
		
		ArrayList<Message> msgs = dao.selectList(firstRow, endRow);
		
		viewData.put("currentPage",pageNumber);
		viewData.put("messageList", msgs);
		viewData.put("pageTotalCount",calPageTotalCount(totalCount));
		viewData.put("startPage", getStartPage(pageNumber));
		viewData.put("endPage", getEndPage(pageNumber));
		return viewData;
	}
	private int calPageTotalCount(int totalCount) {

		int pageTotalCount = 0;
		if(totalCount != 0) {
			pageTotalCount = (int)Math.ceil(
					((double)totalCount / NUM_OF_MESSAGE_PER_PAGE));
		}
		return pageTotalCount;
	}
	public int getStartPage(int pageNum) {

		int startPage = 
				((pageNum-1)/NUM_OF_NAVI_PAGE)*NUM_OF_NAVI_PAGE + 1;
		
		return startPage;
	}
	public int getEndPage(int pageNum) {

		int endPage 
		= (((pageNum-1)/NUM_OF_NAVI_PAGE)+1)
		* NUM_OF_NAVI_PAGE;
		return endPage;
	}
	
}
