package model;

public class Message {
	private int id;
	private String password;
	private String name;
	private String message;
	
	public Message() {}
	public Message(String password, String name, String msg) {
		this.password = password;
		this.name = name;
		this.message = msg;
	}
	public Message(int id, String password, String name, String msg) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.message = msg;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
