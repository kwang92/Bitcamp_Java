import java.util.Scanner;

public class Insert_Sort {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		final int SIZE = input.nextInt();
		int[] arr = new int[SIZE];
		int cnt = 0;
		for(int i = 0; i < SIZE; i++) {
			arr[i] = input.nextInt();
		}
		
		for(int i = 0; i < SIZE-1; i++) {
			for(int j = i; j >= 0; j--) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					cnt++;
				}
				else {
					break;
				}
			}
		}
		
		for(int num : arr) {
			System.out.print(num+" ");
		}
	}
}
