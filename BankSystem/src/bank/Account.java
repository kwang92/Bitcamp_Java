package bank;

import java.io.Serializable;

public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8868834113136300368L;
	private String account_Number;
	private String password;
	private int balance;
	
	public Account() {}
	public Account(String account, String password) {
		this.account_Number = account;
		this.password = password;
	}
	public boolean checkAccess(String password) {	// 권한 확인
		if(this.password.equals(password)) {
			return true;
		}
		return false;
	}
	public String getPassword() {
		return this.password;
	}
	public String getAccount() {
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
