package bank;

import java.io.Serializable;

public class Account implements Serializable{	// 고객이 가질 계좌클래스
	/**
	 * 
	 */
	private static final long serialVersionUID = -8868834113136300368L;
	private String account_Number;	// 작업을 실행할 key로 쓰일 계좌번호
	private String password;
	private int balance;
	
	public Account() {}
	public Account(String account, String password) {
		this.account_Number = account;
		this.password = password;
	}
	public void setPassWord(String newPwd) {
		this.password = newPwd;
	}
	public String getPassword() {
		return this.password;
	}
	public String getAccountNum() {
		return this.account_Number;
	}
	public void deposit(int money) {
		this.balance += money;
	}
	public void withdraw(int money) {
		this.balance -= money;
	}
	public int getBal() {
		return this.balance;
	}
}
