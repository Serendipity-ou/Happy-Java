package week3;

import java.util.Scanner;

public class CommercialInspection {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int total = 0;
		int number2,number3;
		String number;

		System.out.print("Enter the first 9 digits of an ISBN as integer: ");
		number = input.next();
		int number1 = Integer.parseInt(number);

		for (int i = 9; i >= 1; i--) {
			number2 = number1 % 10;
			total += number2 * i;
			number1 /= 10;
		}
		number3 = total % 11;

		if (number3 == 10)
			System.out.println("The ISBN-10 number is " + number + "X");
		else
			System.out.println("The ISBN-10 number is " + number + number3);	
	}
}
