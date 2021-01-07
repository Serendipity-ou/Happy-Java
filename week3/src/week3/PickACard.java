package week3;

import java.util.Scanner;

public class PickACard {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int number1 = (int)(Math.random() * 13 + 1);
		int number2 = (int)(Math.random() * 4 + 1);
		
        String str1 = "" ;
        String str2 = "" ;
		
		if (number1 == 1)
			str1 = "Ace";
		else if (number1 == 2)
			str1 = "2";
		else if (number1 == 3)
			str1 = "3";
		else if (number1 == 4)
			str1 = "4";
		else if (number1 == 5)
			str1 = "5";
		else if (number1 == 6)
			str1 = "6";
		else if (number1 == 7)
			str1 = "7";
		else if (number1 == 8)
			str1 = "8";
		else if (number1 == 9)
			str1 = "9";
		else if (number1 == 10)
			str1 = "10";
		else if (number1 == 11)
			str1 = "Jack";
		else if (number1 == 12)
			str1 = "Queen";
		else if (number1 == 13)
			str1 = "King";

		if (number2 == 1)
			str2 = "Clubs";
		else if (number2 == 2)
			str2 = "Diamonds";
		else if (number2 == 3)
			str2 = "Hearts";
		else if (number2 == 4)
			str2 = "Spades";
		
		System.out.println("The card you picked is " + str1 + " of " + str2);
	}
}
