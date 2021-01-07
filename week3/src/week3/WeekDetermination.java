package week3;

import java.util.Scanner;

public class WeekDetermination {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter year: (e.g., 2012): ");
		int year = input.nextInt();
		
		System.out.print("Enter month: 1-12: ");
		int month = input.nextInt();
		
		System.out.print("Enter the day of the month: 1-31: ");
		int day =input.nextInt();
		
		if(month == 1 || month == 2){
            month = month + 12;
            year = year - 1;
        }
		
		int j = year / 100;
		if (j < 0)
			j=-j;
		int k = year % 100;
		int h = (day + 26 * (month + 1) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;
		
		System.out.print("Day of the week is ");
		if(h == 0)
			System.out.println("Saturday");
		else if(h == 1)
			System.out.println("Sunday");
		else if(h == 2)
			System.out.println("Monday");
		else if(h == 3)
			System.out.println("Tuesday");
		else if(h == 4)
			System.out.println("Wednesday");
		else if(h == 5)
			System.out.println("Thursday");
		else if(h == 6)
			System.out.println("Friday");
	}
}