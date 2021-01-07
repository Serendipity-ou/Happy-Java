package work13;

import java.util.Scanner;

public class HexFormatExceptionwww {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.print("Enter a hex number: ");
        String hex = input.nextLine();
        hexToDec(hex.toUpperCase());
	}
	
	public static void hexToDec(String hex) {
		int value = 0;
		try {
			for(int i = 0; i < hex.length(); i++) {
				char hexChar = hex.charAt(i);
				if ((hexChar >= 'A' && hexChar <= 'F')||(hexChar >= '0' && hexChar <= '9'))
					value = value * 16 + hexCharToDecimal(hexChar);
				else
					throw new Exception("Wrong");
			}
			System.out.println("The decimal value for hex number is: " + value);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	public static int hexCharToDecimal(char ch) {
		if (ch >= 'A' && ch <= 'F')
			return 10 + ch - 'A';
		else
			return ch - '0';
	}
	
	public class HexFormatException extends Exception{
		private String num;
		
		 public HexFormatException(String num){
		        super(num);
		        this.num = num;
		    }
	}
}

