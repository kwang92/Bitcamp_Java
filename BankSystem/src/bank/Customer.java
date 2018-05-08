package bank;

import java.io.Serializable;

public class Customer implements Serializable{

	private static final long serialVersionUID = -101140915114665164L;
	private String uID;	// Priamry key
	private String name;
	private String address;
	private int age;

	private Account account;
	

	public Customer() {
		this.account = new Account();
	}
	public Customer(String acnt, String pwd) {
		this.account = new Account(acnt, pwd);
	}
	public Customer(String name, String account_Number, String password) {
		this.name = name;
		this.account = new Account(account_Number, password);
		System.out.println("계좌 생성완료");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Account getAccount() {
		return account;
	}
}
