
public class Select_Sort {
	public static void main(String[] args) {
		int[] arr = {3, 5, 4, 1, 2};
		int index = 0, min;
		
		for(int i = 0; i < arr.length-1; i++) {	// 마지막 값은 자동으로 최대 값이 되므로 arr길이 -1 만큼 i 반복문 실행
			min = arr[i+1];	// min(최소값)의 초기값으로 arr[i+1]을 넣어준다. 
			index = i+1;	// 최소값이 바뀌는 순간의 인덱스(j)값을 기억하기 위한 변수
			
			for(int j = i+1; j < arr.length; j++) {	// i를 제외한 나머지 값들 중의 최소값 추출
				if(min > arr[j]) {
					min = arr[j];
					index = j;
				}
			}
			if(arr[i] > min) {	// i를 제외한 나머지 수들중 추출된 최소값과 arr[i]값을 비교 후 swap, 혹은 그냥 진행
				int tmp = arr[i];
				arr[i] = min;
				arr[index] = tmp;
			}
		}		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
	}
}
