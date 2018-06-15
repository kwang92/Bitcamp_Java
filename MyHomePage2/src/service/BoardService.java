package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dao.BoardDao;
import model.Board;
import model.Member;


public class BoardService {
	private static BoardService service;
	private BoardDao dao;
	private static final int NUM_OF_MESSAGE_PER_PAGE = 5;
	private static final int NUM_OF_NAVI_PAGE = 5;
	
	private BoardService() {
		dao = BoardDao.getInstance();
	}
	public static BoardService getInstance() {
		service = new BoardService();

		return service;
	}
	public boolean updateBoard(Board brd) {
		if(dao.updateBoard(brd)) {
			return true;
		}
		return false;
	}
	public boolean updateView(int id) {
		if(dao.updateViewCount(id)) {
			return false;
		}
		return false;
	}
	public int countTotal(String id) {
		return dao.countTotal(id);
	}
	public boolean writeBoard(Board brd, Member mem) {
		if(dao.addBoard(brd, mem)) {
			return true;
		}
		return false;
	}
	public boolean delBoard(int bid) {
		if(dao.delBoard(bid)) {
			return true;
		}
		
		return false;
	}
	public Board getOneBoard(int id) {
		Board brd = dao.selectOne(id);
		
		return brd;
	}
	public List<Board> getBoardByName(String name){
		List<Board> bList = dao.getBoardsByName(name);

		return bList;
	}
	public List<Board> getBoardByTitle(String title){
		List<Board> bList = dao.getBoardsByTitle(title);

		return bList;
	}
	public List<Board> getAllBoards(){
		List<Board> bList = new ArrayList<Board>();
		bList = dao.getAllBoards();

		return bList;
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
		
		
		ArrayList<Board> boards = dao.selectList(firstRow, endRow);
		
		viewData.put("currentPage",pageNumber);
		viewData.put("brdList", boards);
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
