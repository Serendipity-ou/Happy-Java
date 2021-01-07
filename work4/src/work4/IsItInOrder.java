package work4;

import java.util.Scanner;

public class IsItInOrder {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter list: ");
		int n;
		int flag = 1;
		int maxx = 1000;
		int[] a = new int[maxx];
		
		n = input.nextInt();
		for(int i = 0; i < n; i++) {
			a[i] = input.nextInt();
		}
		for(int i = 1; i < n; i++) {
			if(a[i-1]>a[i]) {
				flag=-1;
				System.out.println("The list is not sorted");
				break;
			}
		}
		if(flag == 1)
			System.out.println("The list is already sorted");
	}
}