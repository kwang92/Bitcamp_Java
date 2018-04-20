import java.util.ArrayList;
import java.util.Scanner;

public class Queue_Strut {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList que = new ArrayList();
		int cmd_Line = input.nextInt();
		String[] cmd = new String[cmd_Line];
		int data_cnt = 0;
		
		input.nextLine();	
		for(int i = 0; i < cmd_Line; i++) {
			cmd[i] = input.nextLine();
		}

		for(int i = 0; i < cmd_Line; i++) {
			switch(cmd[i].charAt(0)) {
			case 'i':
				que.add(cmd[i].substring(2, cmd[i].length()));
				data_cnt++;
				break;
			case 'o':
				if(data_cnt == 0) {
					System.out.println("empty");
					break;
				}
				System.out.println(que.get(0));
				que.remove(0);
				data_cnt--;
				break;
			case 'c':
				System.out.println(data_cnt);
				break;
			}
		}
	}
}
