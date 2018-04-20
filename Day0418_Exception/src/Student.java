
public class Student {
	private int numOfSubject;
	private int totalScore;

	public Student() {};
	public Student(int totalScore, int numOfSubject) {
		this.numOfSubject = numOfSubject;
		this.totalScore = totalScore;
	}
	public void showAvg() throws Exception{
		int result = totalScore / numOfSubject;
		
	}
}