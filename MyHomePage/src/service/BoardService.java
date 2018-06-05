package service;

import dao.BoardDao;
import model.Board;
import model.Member;

public class BoardService {
	private static BoardService service;
	private BoardDao dao;
	private BoardService() {
		dao = BoardDao.getInstance();
	}
	public static BoardService getInstance() {
		service = new BoardService();
		
		return service;
	}
	public boolean writeBoard(Board brd, Member mem) {
		if(dao.addBoard(brd, mem)) {
			return true;
		}
		return false;
	}
}
