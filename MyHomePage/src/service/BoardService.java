package service;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
}
