import java.util.Random;

class LottoMaker {
	private int[] number;
	private int start, end;
	private Random ran;
	
	public LottoMaker() {
		number = new int[6];
		ran = new Random();
		this.start = 1;
		this.end = 45;
	}
	public LottoMaker(int start, int end) {
		number = new int[6];
		ran = new Random();
		this.start = start;
		this.end = end;
	}
	public void makeNumber() {
		number[0] = ran.nextInt(end)+start;
		for(int i = 1; i < 6; i++) {	// 6개의 난수를 생성할 반복문
			number[i] = ran.nextInt(end)+start;	// 난수 생성, count 증가
			for(int j = 0; j <= i-1; j++) {	// 첫번 째 생성 된 난수부터 현재 생성한 난수 전까지 중복 검사
				
				if(number[j] == number[i]) {	// 중복이 있으면 i 인덱스 1 감소 후 중복검사 반복문 break
					i--;	 
					break;
				}
			}
		}
	}
	public void display() {
		for(int i = 0; i < number.length; i++) {
			System.out.print(number[i]+" ");
		}
		System.out.println();
	}
	public int[] getLotto() {
		return number;
	}
}
