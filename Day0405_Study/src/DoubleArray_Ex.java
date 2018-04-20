
public class DoubleArray_Ex {
	public static void main(String[] args) {
		// 2차원 배열
		int[][] arr = new int[3][5];
		
		
		for(int i = 1 ; i <= arr.length; i++) {
			for(int j = 0; j < arr[i-1].length; j++) {
				arr[i-1][j] = i+j;
			}
		}
		
		
		/*
		for(int i = 0 ; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}*/
		
		int[] a = new int[5];
		int[] a2 = new int[3];
		int[] a3 = new int[6];
		
		int[][] b = new int[5][];
		int[][] c = new int[6][4];
		
		// 각 원소들의 길이(length)메소드를 사용하면 각각 길이가 다르더라도 모두 접근이 가능하다.
		
		b[0] = a;
		b[0][0] = 5;
		System.out.println(a[0]);
		a[0] = 7;
		System.out.println(b[0][0]);
		b[1] = a2;
		a2[0] = 10;
		System.out.println(b[1][0]);
		System.out.println(b[1][4]);
		b[2] = a3;
		b[2][0] =33;
		System.out.println(a3[0]);
	}
}