package bank;

import java.io.Serializable;

public class TransAction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4674767518932686845L;
	private String job;
	private String target;
	private String msg;
	private int money;
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsg() {
		return this.msg;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
}
