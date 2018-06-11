package controller;

import controller.action.Action;
import controller.action.MemberCheckLoginForm;

public class MemberActionFactory {
	public static Action getAction(String command) {
		Action action = null;
		if(command.equals("MemberCheckLoginForm")) {
			action = new MemberCheckLoginForm();
		}
		
		return action;
	}
}
