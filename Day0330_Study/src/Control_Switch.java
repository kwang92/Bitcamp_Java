import java.util.Random;

public class Control_Switch {
	public static void main(String[] args) {
		Random ran = new Random();
		int su1 = ran.nextInt(6)+1;
//		int su2 = (int)(Math.random()*10)%6+1;
//		int su2 = (int)((Math.random()*6)+1);
		String dice_Num;
		 
		switch(su1) {
		case 1:
			dice_Num = "눈금은 1입니다.";
			break;
		case 2:
			dice_Num = "눈금은 2입니다.";
			break;
		case 3:
			dice_Num = "눈금은 3입니다.";
			break;
		case 4:
			dice_Num = "눈금은 4입니다.";
			break;
		case 5:
			dice_Num = "눈금은 5입니다.";
			break;
		default:
			dice_Num = "눈금은 6입니다.";
		}
		System.out.println(dice_Num);
	}
}