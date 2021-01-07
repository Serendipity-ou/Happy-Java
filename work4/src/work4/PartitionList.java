package work4;

import java.util.Scanner;

public class PartitionList {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int maxx = 1000;
		int[] list = new int[maxx];
		
		System.out.print("Enter list: ");
		list[0] = input.nextInt();
		for(int i = 1; i <= list[0]; i++) 
			list[i] = input.nextInt();
		
		System.out.print("After the partition, the list is ");
		partition(list);
	}
	public static void partition(int[] list) {
		for(int i = 2; i <= list[0]; i++) {
			if(list[i] <= list[1]) 
				System.out.print(list[i] + " ");
		}
		System.out.print(list[1] + " ");
		for(int i = 2; i <= list[0]; i++) {
			if(list[i] > list[1]) 
				System.out.print(list[i] + " ");
		}
	}
}