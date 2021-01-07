package work13;

import java.util.Scanner;

public class NumberFormatException2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.print("Enter a hex number: ");
        String binaryString = input.nextLine();
        bin2Dec(binaryString);
	}
	
	public static void bin2Dec(String binaryString) {
		int value = 0;
		try {
			for(int i = 0; i < binaryString.length(); i++) {
				char hexChar = binaryString.charAt(i);
				if (hexChar == '0' || hexChar == '1')
					value = value * 2 + hexChar - '0';
				else
					throw new Exception("NumberFormatException");
			}
			System.out.println("The decimal value for hex number is: " + value);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
