package model;

public class Board {
	private String name;	// 작성자 이름
	private String pass;	// 게시물 비밀번호
	private String email;	// 작성자 이메일
	private String title;	// 게시 글 제목
	private String content;	// 게시 글 내용
	
	public Board() {}
	public Board(String name, String pass, String email, String title, String content) {
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.title = title;
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return String.format("작성자 : %s<br>비밀번호 : %s<br>이메일 : %s<br>제목 : %s<br>내용 : %s<br>",
				this.name, this.pass, this.email, this.title, this.content);
	}
	
	
}
