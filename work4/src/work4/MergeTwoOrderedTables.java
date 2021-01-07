package work4;

import java.util.Scanner;
import java.util.Arrays;

public class MergeTwoOrderedTables {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int maxx = 1000;
		int[] list1 = new int[maxx];
		int[] list2 = new int[maxx];
		
		System.out.print("Enter list1: ");
		list1[0] = input.nextInt();
		for(int i = 1; i <= list1[0]; i++) 
			list1[i] = input.nextInt();
		
		System.out.print("Enter list2: ");
		list2[0] = input.nextInt();
		for(int i = 1; i <= list2[0]; i++) 
			list2[i] = input.nextInt();
		int[] list3 = merge(list1, list2);
		System.out.print("The merged list is ");
		for(int i = 1; i <= list1[0] + list2[0]; i++)
			System.out.print(list3[i] + " ");
	}
	public static int[] merge(int[] list1, int[] list2) {
		int L;
		int count = 1;
		L = list1[0] + list2[0];
		int[] list3 = new int[L+1];
		
		for(int i = 1; i <= L; i++) {
			if(i <= list1[0])
				list3[i] = list1[i];
			else {
				list3[i] = list2[count];
				count++;
			}
		}
		Arrays.sort(list3,1,L+1);
		return list3;
	}
}
