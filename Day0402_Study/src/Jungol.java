import java.util.Scanner;

public class Jungol {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int m, n;
		boolean isTrue;
		System.out.print("n 입력: ");
		n = input.nextInt();
		char[][] arr = new char[n][2];
		input.nextLine();
		for(int i = 0; i < n; i++) {
			String tmp = input.nextLine();
			arr[i][0] = tmp.charAt(0);
			arr[i][1] = tmp.charAt(2);
		}
		System.out.print("m 입력: ");
		m = input.nextInt();
		input.nextLine();
		String str = "";
		for(int i = 0; i < m; i++ ) {
			char tmp = input.nextLine().charAt(0);
			isTrue = false;
			for(int j = 0; j < n; j++) {
				if(tmp == arr[j][0]) {
					str += arr[j][1];
					isTrue = true;
					break;
				}
			}
			if(isTrue == false)
				str += tmp;
		}
		System.out.println(str);
		input.close();
	}
}