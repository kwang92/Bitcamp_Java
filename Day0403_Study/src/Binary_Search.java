import java.util.Scanner;

public class Binary_Search {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		final int SIZE = input.nextInt();
		int find;
		int[] arr = new int[SIZE];
		
		for(int i = 0; i<SIZE; i++) {
			arr[i] = input.nextInt();
		}
		find = input.nextInt();
		int[] find_Num = new int[find];
		for(int i = 0; i <find; i++) {
			find_Num[i] = input.nextInt();
		}
		for(int i = 0; i <find; i++) {
			System.out.println(search(arr, find_Num[i], SIZE));
		}
		
	}
	public static int search(int[] arr,int find,int size) {
		int mid, left = 0, right = size;
		
		
		while(left < right) {
			mid = ( left + right )/ 2;
			if(arr[mid] == find) {
				return mid+1;
			}
			else if(arr[mid] > find) {
				right = mid - 1;
				if(arr[right] == find)
					return right+1;
			}
			else {
				left = mid + 1;
				if(arr[left] == find)
					return left+1;
			}
		}
		return 0;
	}
}