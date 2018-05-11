
public enum Member_Enum {
	// 열거형 : 값들의 나열 
	NUM("num"), ID("id"), NAME("name"), PW("pw"), E_MAIL("email"), REG_DATE("regDate");
	
	private String col;
	public String getcol() {
		return col;
	}
	private Member_Enum(String col) {
		this.col = col;
	}
}
