package model;

import java.util.Date;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private Date regDate;	// ¿À´Ã ³¯Â¥
	
	public Member() {
		this.regDate = new Date();
	}
	public Member(String id, String pw, String name, String email) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.regDate = new Date();
	}
	public Member(String id, String pw, String name, String email, Date regDate) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.regDate = regDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegData() {
		return this.regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	
}
