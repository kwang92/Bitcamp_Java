import java.util.ArrayList;
import java.util.Scanner;

public class Jungol {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList store = new ArrayList();
		ArrayList <String>str_Store = new <String>ArrayList();
		String str;

		while(true) {
			str = in.nextLine();

			if(str.equals("END"))
				break;
			str_Store.add(str);
			
		}

		for(int i = 0; i < str_Store.size(); i++) {
			String[] tmp = str_Store.get(i).split(" ");
			for(String str_tmp : tmp){
				if(!store.contains(str_tmp)) {
					store.add(str_tmp);
				}
			}
			for(int j = 0; j < store.size(); j++) {
				System.out.print(store.get(j)+" ");
			}
			System.out.println();
		}

	}
}