
public class Literal {
	public static void main(String[] args) {
		// Literal 상수       2진수 8진수 16진수
		
		/*
		int decimal, octal, hexaDecimal, binary;
		
		decimal = 14;
		octal = 016;
		hexaDecimal = 0xe;
		binary = 0b1110;
		
		
		System.out.printf("decimal : %d\n",decimal);
		System.out.printf("octal : %d\n",octal);
		System.out.printf("hexaDecimal : %d\n",hexaDecimal);
		System.out.printf("binary : %d\n",binary);
		*/
		
		String oct_Str, hex_Str, bin_Str;
		
		oct_Str = Integer.toOctalString(14);
		hex_Str = Integer.toHexString(14);
		bin_Str = Integer.toBinaryString(14);
		
		System.out.println(oct_Str + "  " + hex_Str + "  "+bin_Str);
	}
	
}