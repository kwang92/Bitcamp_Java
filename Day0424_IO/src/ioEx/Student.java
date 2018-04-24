package ioEx;

import java.io.Serializable;

public class Student implements Serializable {
	
	
	private static final long serialVersionUID = 8998292384308117044L;	// 클래스의 버젼정보를 확인하는 데이터 값
	private String name;
	private int grade;
	private int score;
	
	public Student() {}
	public Student(String name, int grade, int score) {
		this.name = name;
		this.grade = grade;
		this.score = score;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", score=" + score + "]";
	}
	
}