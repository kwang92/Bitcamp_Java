package studentManagement;

import java.io.Serializable;

public class Student implements Serializable{
	// Serializable 클래스에서 
	// 정보를 보내기 싫은 변수 앞에 transient 키워드를 쓰면 해당 데이터는 직렬화(Serializable)대상에서 제외된다.
	// transient로 저장된 데이터를 저장했다가 다시 불러오면 기본값으로 초기화된 데이터가 불려온다.
	private static int totalStudent = 0;
	private String name;
	private transient int grade;	// 이런식으로 Serializable 클래스안 변수 앞에 transient를 붙여주면
	Score score;					// grade 정보는 직렬화 대상에서 제외.
	
	public Student() {
		this.name = "Empty";
		this.score = new Score();
		totalStudent++;
	}
	public Student(String name, int grade) {
		this.score = new Score();
		this.name = name;
		this.grade = grade;
		totalStudent++;
	}
	public Student(String name, int grade, Score score) {
		this.name = name;
		this.grade = grade;
		this.score = score;
		totalStudent++;
	}
	public Student(String name, int grade, int kor, int eng, int math) {
		this.name = name;
		this.grade = grade;
		this.score = new Score(kor, eng, math);
		totalStudent++;
	}
	
	public void setKor(int kor) {
		this.score.setkor(kor);
	}
	public void setEng(int eng) {
		this.score.setEng(eng);
	}
	public void setMath(int math) {
		this.score.setMath(math);
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public void setScore(int kor, int eng, int math) {
		this.score = new Score(kor, eng, math);
	}
	public void setName(String name) {

		this.name = name;
	}
	public double getAverage() {
		int sum = score.getkor() + score.getEng() + score.getMath();
		return (double)sum / score.getTotalSub();
	}	
	public String getName() {
		return name;
	}
	public Score getScore() {
		return score;
	}
	public int getGrade() {
		return grade;
	}
	public static int getTotalStu() {
		return totalStudent;
	}
	public String toString() {
		return String.format(" 이름 : %5s , 학년 : %d, 국어 : %3d, 영어 : %3d, 수학 : %3d, 평균 : %3.2f"
							, this.name, this.grade 
							, this.score.getkor(), this.score.getEng(), this.score.getMath(), this.getAverage());
	}
}