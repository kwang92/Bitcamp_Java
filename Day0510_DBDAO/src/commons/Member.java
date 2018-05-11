package commons;

public enum Member {
	//열거형 : 값들의 나열
	NUM("num"), 
	ID("id"), 
	NAME("name"), 
	PW("pw"), 
	EMAIL("email"), 
	REG_DATE("regDate");
	
	private String col;
	
	public String getCol() {
		return col;
	}
	private Member(String col) {
		this.col = col;
	}
}
