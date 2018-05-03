package bank;

import java.io.Serializable;

public class TransAction implements Serializable{
	
	private static final long serialVersionUID = 4674767518932686845L;
	private String job;			// 요청할 작업을 저장할 변수
	private String target;		// 계좌이체 시 상대방 계좌를 저장할 변수
	private String msg;			// 서버로 전송할 정보가 필요할 시 저장할 변수
	private int money;			// 작업에 해당하는 금액을 저장하는 변수
	
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
