package model;

public class Student {
	private String sid;
	private String name;
	private String grade;
	private int classNum;
	
	public Student() {}
	public Student(String sid, String name, String grade, int classNum) {
		this.sid = sid;
		this.name = name;
		this.grade = grade;
		this.classNum = classNum;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	
}
