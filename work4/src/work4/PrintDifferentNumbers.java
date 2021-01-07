package work4;

import java.util.Scanner;

public class PrintDifferentNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter ten numbers: ");
		int maxx = 100;
		int[] a = new int[maxx];
		int[] b = new int[maxx];
		int num, count = 0;
		int total = 0;
		
		for(int i = 0; i < maxx; i++) {
			a[i] = 0;
		}
		
		for(int i = 0; i < 10; i++) {
			num = input.nextInt();
			if(a[num] == 0) {
				b[count] = num;
				a[num]++;
				count++;
			}
		}
		System.out.println("The number of distinct number is " + count);
		System.out.print("The distinct numbers are: ");
		for(int i = 0; i < count; i++) {
			System.out.print(b[i] + " ");
		}
	}
}