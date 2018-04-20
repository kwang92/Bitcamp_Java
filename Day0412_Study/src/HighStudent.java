
public class HighStudent extends Student{
	private boolean nightStudy;
	private String dep;
	private int[] mockTestGrade;
	private int mock_cnt;
	
	public HighStudent() {
		mockTestGrade = new int[3];
		nightStudy = true;
		dep = "미정";
		mock_cnt = 0;
	}
	public void setDep(String dep) {
		this.dep = dep;		// 과 정보 (문과/이과) 설정
	}
	public String getDep() {	// 과 정보 (문과/이과) 반환
		return this.dep;
	}
	public void setNightStudy(boolean ns) {	// 야자여부 입력
		this.nightStudy = ns;
	}
	public boolean getNightStudy() {	// 야자여부 반환
		return this.nightStudy;
	}
	public void setGradeByScore() {	// 성적 평균에 따른 등급설정
		int sum = this.score.getSum();
		int grade = 0;
		switch( sum / this.score.getTotalSub() ) {
		case 10:case 9:
			grade = 1;
			break;
		case 8:
			grade = 2;
			break;
		case 7:
			grade = 3;
			break;
		default:
			grade = 4;
		}
		insertMockGrade(grade);
	}
	public void insertMockGrade(int grade) {	// 모의고사 등급입력
		this.mockTestGrade[mock_cnt++] = grade;
	}
	public int[] getMockGrade() {	// 모의고사 등급목록 반환
		return this.mockTestGrade;
	}
	public int getMockGradeAvg() {	// 총 모의고사 평균등급 반환
		int sum = 0;
		for(int i = 0; i < mock_cnt; i++) {
			sum += mockTestGrade[i];
		}
		
		return sum/mock_cnt;
	}
}