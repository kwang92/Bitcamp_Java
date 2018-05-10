
public class Member {
	public static int MEMBER_CNT = 1;
	private int num;
	private String id;
	private String pw;
	private String name;
	private String e_Mail;
	private String reg_Date;
	
	public Member(int num, String id, String pw, String name, String e_Mail, String reg_Date) {
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.e_Mail = e_Mail;
		this.reg_Date = reg_Date;
	}
	public Member(int num, String id, String pw, String name, String e_Mail) {
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.e_Mail = e_Mail;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getE_Mail() {
		return e_Mail;
	}
	public void setE_Mail(String e_Mail) {
		this.e_Mail = e_Mail;
	}
	public String getReg_Date() {
		return reg_Date;
	}
	public void setReg_Date(String reg_Date) {
		this.reg_Date = reg_Date;
	}
	public static void increaseMember() {
		MEMBER_CNT++;
	}
	public static void decreaseMember() {
		MEMBER_CNT--;
	}
	public static int getMemberCnt() {
		return MEMBER_CNT;
	}
	@Override
	public String toString() {
		return "Member [num=" + num + ", id=" + id + ", pw=" + pw + ", name=" + name + ", e_Mail=" + e_Mail
				+ ", reg_Date=" + reg_Date + "]";
	}
	
	
}
