package dao;

import java.util.List;

import model.Board;

public interface BoardDao {
	// selectOne, insert, update, delete, selectAll
	public int insertBoard(Board board);
	public int updateBoard(Board board);
	public int updateViewCount(String num);
	public int deleteBoard(int num);
	public Board selectOne(String num);
	public List<Board> selectAll();
}
