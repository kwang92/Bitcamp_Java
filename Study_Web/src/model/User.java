package model;

public class User {
	private String userid;
	private String userpwd;
	private String name;
	private String gender;
	private String birth;
	
	public User() {}
	public User(String userid, String userpwd) {
		this.userid = userid;
		this.userpwd = userpwd;
	}
	public User(String userid, String userpwd, String name) {
		this.userid = userid;
		this.userpwd = userpwd;
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
}
