
public class ArrayCopy {
	public static void main(String[] args) {
		/*
		// 배열복사	( 값 복사, 주소 복사 )
		int	num1 = 10;
		int num2 = num1;	// 값 복사 
		
		System.out.println("num1 :"+num1 );
		System.out.println("num2 :"+num2);
		
		num2++;
		
		System.out.println("num1 :"+num1 );
		System.out.println("num2 :"+num2);
		
		int[] arr1 = {1, 3, 5};
		int[] arr2 = arr1; // 얕은 복사 ( shallow copy )-> 주소복사 
		
		display(arr1,arr2);			
		arr1[0]++;
		display(arr1,arr2);
		arr2[0]++;
		display(arr1,arr2);
		
		
		int[] arr3 = new int[arr1.length];
		
		for(int i = 0; i < arr3.length; i++) {	// 깊은 복사 ( deep copy ) -> 값 자체 복사
			arr3[i] = arr1[i];
		}
		display(arr1,arr3);
		arr3[0]++;
		display(arr1,arr3);
		*/
		int[][] arr4 = {{1,2,3},{4,5,6,7,8},{9,10}};
		
		for(int i = 0; i < arr4.length; i++) {
			for(int j = 0; j < arr4[i].length; j++) {
				System.out.printf("%2d ",arr4[i][j]);
			}
			System.out.println();
		}
	}
	public static void display(int []arr1,int []arr2) {
		System.out.print("arr1: ");
		for(int num : arr1) {
			System.out.print(num + " ");
		}
		System.out.print("arr2: ");
		for(int num : arr2) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}