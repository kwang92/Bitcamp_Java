
public class Nested_Loop2 {
	public static void main(String[] args) {
		/*
		 *  		*
		 *  		**
		 *  		***
		 * 			****
		 * 			*****
		 */
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println();
		for(int i = 4; i >= 0; i--) {
			for(int j = 0; j <5; j++) {
				if(i > j) {
					System.out.print(" ");
					continue;
				}
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
