import java.util.ArrayList;
import java.util.Scanner;

public class Stack_Strut {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList stack = new ArrayList();
		int cmd_Num = input.nextInt();
		String[] cmd = new String[cmd_Num];
		int index = -1;
		input.nextLine();
		for(int i = 0; i < cmd_Num; i++) {
			cmd[i] = input.nextLine();
		}

		for(int i = 0; i < cmd_Num; i++) {
			switch(cmd[i].charAt(0)) {
			case 'i':
				stack.add(cmd[i].substring(2, cmd[i].length()));
				index++;
				break;
			case 'c':
				if(index == -1) {
					System.out.println(0);
					break;
				}
				System.out.println(index+1);
				break;
			case 'o':
				if(index == -1) {
					System.out.println("empty");
					break;
				}
				System.out.println(stack.get(index));
				stack.remove(index);
				index--;
				break;
			}
		}

	}
}
