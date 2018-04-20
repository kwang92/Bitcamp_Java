import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Buble {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		int num = input.nextInt();
		int[] arr = new int[num];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}
		int len = arr.length;
		for(int i = 0; i < len-1; i++) {
			for(int j = 0; j < len-1-i; j++) {
				if(arr[j] >arr[j+1]) {
					int tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}
			}
			for(int j = 0; j < len; j++)
				System.out.print(arr[j]+" ");
			System.out.println();
	
		}
		input.close();
	}
}
