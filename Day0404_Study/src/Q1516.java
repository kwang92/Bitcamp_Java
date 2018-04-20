import java.util.Scanner;

public class Q1516 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		final String END_CMD = "END";
		String[] tmp; 
		while(true) {
			String str = input.nextLine();
			int cnt = 0;
			if(str.equals(END_CMD)) {
				break;
			}
			tmp = str.split(" ");
			for(int i = 0; i < tmp.length-1; i++) {
				for(int j = i+1; j < tmp.length; j++) {
					if(tmp[i].equals(tmp[j])) {
						cnt++;
					}
				}
				Excep:
				for(int j = 0; j<tmp.length; j++) {
					if(tmp[i].equals(tmp[j])) {
						tmp[j] = "";
						for(int k = 0; k < tmp[i].length(); k++)
							tmp[j] += " "; 
						break Excep;
					}
				}
				System.out.println(tmp[i]+" : "+cnt);
			}
		}
	}
}
