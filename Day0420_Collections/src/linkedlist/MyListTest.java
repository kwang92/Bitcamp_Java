package linkedlist;

import java.util.Scanner;

public class MyListTest {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		Scanner in = new Scanner(System.in);	// 테스트용 scanner 객체
		
		int num = 0;
		loop:
		while(num != -1) {
			System.out.println("[1]노드추가 [2]노드set [3]노드삭제 [4]get노드 [5]사이즈 [6]노드출력");
			System.out.print("입력 : ");
			num = in.nextInt();
			String str;
			int index;
			switch(num) {
			case 1:
				System.out.print("넣을 데이터입력 : ");
				str = in.next();
				list.add(str);
				break;
			case 2:
				System.out.print("넣을 인덱스 입력 : ");
				index = in.nextInt();
				System.out.print("넣을 데이터입력 : ");
				str = in.next();
				list.set(index, str);
				break;
			case 3:
				System.out.print("삭제 할 노드 인덱스 : ");
				index = in.nextInt();
				list.remove(index);
				break;
			case 4:
				System.out.print("가져 올 노드 인덱스 : ");
				index = in.nextInt();
				System.out.println("가져온 노드 : "+list.get(index));
				break;
			case 5:
				System.out.println("노드 사이즈 : "+list.size());
				break;
			case 6:
				System.out.println(list);
				break;
			default:
				break loop;
			}
			System.out.println();
		}
	}
}