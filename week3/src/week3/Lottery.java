package week3;

import java.util.Scanner;

public class Lottery {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int LotteryNumber = (int)(Math.random() * 900 + 100);
		int number = input.nextInt();
		int number1 = number % 10;
		int number2 = (number / 10) % 10;
		int number3 = number / 100;
		
		int LotteryNumber1 = LotteryNumber % 10;
		int LotteryNumber2 = (LotteryNumber / 10) % 10;
		int LotteryNumber3 = LotteryNumber / 100;
		
		if(number == LotteryNumber)
			System.out.println("You win $: 10,000");
		else if((number1 == LotteryNumber1 && number2 == LotteryNumber3 
			&& number3 == LotteryNumber2) || (number1 == LotteryNumber2 
			&& number2 == LotteryNumber1 && number3 == LotteryNumber3) 
			|| (number1 == LotteryNumber2 && number2 == LotteryNumber3 
			&& number3 == LotteryNumber1) || (number1 == LotteryNumber3 
			&& number2 == LotteryNumber1 && number3 == LotteryNumber2)
			|| (number1 == LotteryNumber3 && number2 == LotteryNumber2 
			&& number3 == LotteryNumber1))
			System.out.println("You win $: 3,000");
		else if((number1 == LotteryNumber1) || (number2 == LotteryNumber1) 
			|| (number3 == LotteryNumber1) || (number1 == LotteryNumber2) 
			|| (number2 == LotteryNumber2) || (number3 == LotteryNumber2)
			|| (number1 == LotteryNumber3) || (number2 == LotteryNumber3) 
			|| (number3 == LotteryNumber3))
			System.out.println("You win $: 1,000");
		else
			System.out.println("You get nothing");
	}
}
