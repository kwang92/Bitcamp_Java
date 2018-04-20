
class Student {
	private String name;
	private int korea_score;
	private int english_score;
	private int math_score;
	private double avg;
	
	public void display() {
		this.avg = ((double)korea_score + english_score + math_score) / 3;
		System.out.println("이름 : "+this.name+" 평균 : "+this.avg);
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setKorea(int kor) {
		this.korea_score = kor;
	}
	public void setEng(int eng) {
		this.english_score = eng;
	}
	public void setMath(int math) {
		this.math_score = math;
	}
}
