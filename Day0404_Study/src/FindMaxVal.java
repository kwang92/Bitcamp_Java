
public class FindMaxVal {
	public static void main(String[] args) {
		int[] arr= {77, 50, 64, 100, 25};
		int max = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println("가장 큰 숫자는 "+max+"입니다.");

	}
}