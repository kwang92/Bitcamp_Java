package model;

public class Member {
	private String mem_id;
	private String password;
	private String name;
	private String email;
	
	public Member() {}
	public Member(String mem_id, String password) {
		this.mem_id = mem_id;
		this.password = password;
	}
	public Member(String mem_id, String password, String name, String email) {
		this.mem_id = mem_id;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	
}
