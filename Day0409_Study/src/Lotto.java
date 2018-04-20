import java.util.Random;

public class Lotto {
	private int[] lottoNumbers;
	private Random ran;
	public Lotto() {
		lottoNumbers = new int[6];
	}
	public Lotto(int[] lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}
	public void makelottoNumbers() {
		Random ran = new Random();
		lottoNumbers[0] = ran.nextInt(45)+1;
		for(int i = 1; i < 6; i++) {	// 6개의 난수를 생성할 반복문
			lottoNumbers[i] = ran.nextInt(45)+1;	// 난수 생성, count 증가
			for(int j = 0; j <= i-1; j++) {	// 첫번 째 생성 된 난수부터 현재 생성한 난수 전까지 중복 검사
				
				if(lottoNumbers[j] == lottoNumbers[i]) {	// 중복이 있으면 i 인덱스 1 감소 후 중복검사 반복문 break
					i--;	 
					break;
				}
			}
		}
		System.out.println("로또 번호생성 완료");
	}
	public void sortLotto() {
		int min, index;
		for(int i = 0; i < lottoNumbers.length-1; i++) {
			min = lottoNumbers[i];
			index = i;
			for(int j = i+1; j < lottoNumbers.length; j++ ) {
				if(lottoNumbers[j] < min) {
					index = j;
					min = lottoNumbers[j];
				}
			}
			lottoNumbers[index] = lottoNumbers[i];
			lottoNumbers[i] = min;
		}
		System.out.println("정렬완료");
	}
	public void printLotto() {
		for(int num : lottoNumbers) {
			System.out.print(num+" ");
		}
		System.out.println();
	}
}
