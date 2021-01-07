package work4;

import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入10个double型的值：");
		int maxx = 1000;
		double temp;
		double[] a = new double[maxx];
		
		for(int i = 0; i < 10; i++) {
			a[i] = input.nextDouble();
		}
		for(int j = 1; j < 10 ; j++) {
			for(int i = 1; i < 10; i++) {
				if(a[i-1] > a[i]) {
					temp = a[i-1];
					a[i-1] = a[i];
					a[i] = temp;
				}
			}
		}
		for(int i = 0; i < 10; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
