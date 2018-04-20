import java.util.Scanner;

public class Sorting {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final int SIZE = in.nextInt();
		int choice = in.nextInt();
		int[] arr = new int[SIZE];
		boolean isSwap;
		for(int i = 0; i < SIZE; i++) {
			arr[i] = in.nextInt();
		}
		
		switch(choice) {
		case 0:
			for(int i = 0; i < SIZE-1; i++) {
				isSwap = false;
				for(int j = 0; j < SIZE-1-i; j++) {
					if(arr[j] > arr[j+1]) {
						int tmp = arr[j+1];
						arr[j+1] = arr[j];
						arr[j] = tmp;
						isSwap = true;
					}
				}
				if(!(isSwap))
					break;
			}
			break;
		case 1:
			for(int i = 0; i < SIZE-1; i++) {
				isSwap = false;
				for(int j = 0; j < SIZE-1-i; j++) {
					if(arr[j] < arr[j+1]) {
						int tmp = arr[j+1];
						arr[j+1] = arr[j];
						arr[j] = tmp;
						isSwap = true;
					}
				}
				if(!(isSwap))
					break;
			}
			break;
		}
		for(int i = 0; i < SIZE; i++) {
			System.out.println(arr[i]);
		}
	}
}
