package controller;

import controller.action.Action;
import controller.action.BoardCheckPassAction;
import controller.action.BoardCheckPassFormAction;
import controller.action.BoardDeleteAction;
import controller.action.BoardListAction;
import controller.action.BoardUpdateAction;
import controller.action.BoardUpdateFormAction;
import controller.action.BoardViewAction;
import controller.action.BoardWriteAction;
import controller.action.BoardWriteFormAction;

public class BoardActionFactory {
	public static Action getAction(String command) {
		Action action = null;
		if(command.equals("boardList")) {	// 게시글 목록
			action = new BoardListAction();
		}
		else if(command.equals("boardWriteForm")) {	// 게시글 작성 폼
			action = new BoardWriteFormAction();
		}
		else if(command.equals("boardWrite")) {	// 게시글 작성
			action = new BoardWriteAction();
		}
		else if(command.equals("boardView")) {	// 게시글 상세보기
			action = new BoardViewAction();
		}
		else if(command.equals("boardUpdate")) { // 게시글 수정적용
			action = new BoardUpdateAction();
		}
		else if(command.equals("boardUpdateForm")) { // 게시글 수정 폼
			action = new BoardUpdateFormAction();
		}
		else if(command.equals("boardDelete")) { // 게시글 삭제적용
			action = new BoardDeleteAction();
		}
		else if(command.equals("boardCheckPass")) { // 게시글 비밀번호 확인
			action = new BoardCheckPassAction();
		}
		else if(command.equals("boardCheckPassForm")) { // 게시글 비밀번호 확인 폼
			action = new BoardCheckPassFormAction();
		}

		return action;
	}
}
