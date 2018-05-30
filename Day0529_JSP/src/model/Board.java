package model;

public class Board {
	private String name;	// �ۼ��� �̸�
	private String pass;	// �Խù� ��й�ȣ
	private String email;	// �ۼ��� �̸���
	private String title;	// �Խ� �� ����
	private String content;	// �Խ� �� ����
	
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
		return String.format("�ۼ��� : %s<br>��й�ȣ : %s<br>�̸��� : %s<br>���� : %s<br>���� : %s<br>",
				this.name, this.pass, this.email, this.title, this.content);
	}
	
	
}
