
public class Score {
	private int total;

	public void storeTotal(int total) {
		this.total = total;
	}
	public void setTotal(int score) throws oddNumberException {
		if(score % 2 == 1) {
			throw new oddNumberException();		
		}
		this.total += score;
	}
	public void showTotal() {
		System.out.println("총점은 "+total+"입니다.");
	}

}