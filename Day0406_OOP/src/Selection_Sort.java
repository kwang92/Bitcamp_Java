
public class Selection_Sort {
	public static void main(String[] args) {
		int arr[] = {3, 5, 4, 1, 2};
		int min, index;
		for(int i = 0; i < arr.length-1; i++) {
			min = arr[i];
			index = i;
			for(int j = i + 1; j < arr.length; j++) {
				if( min > arr[j]) {
					min = arr[j];
					index = j;
				}
			}
			arr[index] = arr[i];
			arr[i] = min;
			
			// 굳이 tmp를 써서 swap해줄 필요가 없었는 듯.. 
		/*	int tmp = arr[i];
			arr[i] = arr[index];
			arr[index] = arr[i];*/
		}
		for(int num : arr) {
			System.out.print(num+" ");
		}
	}
}
// 192.168.0.26:80