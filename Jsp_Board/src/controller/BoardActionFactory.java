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
		if(command.equals("boardList")) {	// �Խñ� ���
			action = new BoardListAction();
		}
		else if(command.equals("boardWriteForm")) {	// �Խñ� �ۼ� ��
			action = new BoardWriteFormAction();
		}
		else if(command.equals("boardWrite")) {	// �Խñ� �ۼ�
			action = new BoardWriteAction();
		}
		else if(command.equals("boardView")) {	// �Խñ� �󼼺���
			action = new BoardViewAction();
		}
		else if(command.equals("boardUpdate")) { // �Խñ� ��������
			action = new BoardUpdateAction();
		}
		else if(command.equals("boardUpdateForm")) { // �Խñ� ���� ��
			action = new BoardUpdateFormAction();
		}
		else if(command.equals("boardDelete")) { // �Խñ� ��������
			action = new BoardDeleteAction();
		}
		else if(command.equals("boardCheckPass")) { // �Խñ� ��й�ȣ Ȯ��
			action = new BoardCheckPassAction();
		}
		else if(command.equals("boardCheckPassForm")) { // �Խñ� ��й�ȣ Ȯ�� ��
			action = new BoardCheckPassFormAction();
		}

		return action;
	}
}
