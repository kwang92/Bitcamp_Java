package bank;

import java.io.Serializable;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -101140915114665164L;
	private String name;
	private String address;
	private String grade;
	private int age;
	private boolean access;

	private String datatype;
	private Account account;
	

	public Customer() {
		this.account = new Account();
		this.access = false;
	}
	public Customer(String acnt, String pwd) {
		this.account = new Account(acnt, pwd);
	}
	public Customer(String name, String account_Number, String password) {
		this.name = name;
		this.account = new Account(account_Number, password);
		this.access = false;
		System.out.println("계좌 생성완료");
	}
	public boolean checkAccess(String password) {	// prompt로 들어온 password를 해당 고객의 계좌비밀번호와 맞는지 확인
		access = this.account.checkAccess(password);
		return access;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isAccess() {
		return access;
	}
	public Account getAccount() {
		return account;
	}
	public void setDataType(String type) {
		this.datatype = type;
	}
	public String getDataType() {
		return this.datatype;
	}
}
