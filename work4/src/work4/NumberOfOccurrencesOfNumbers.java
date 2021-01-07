package work4;

import java.util.Scanner;

public class NumberOfOccurrencesOfNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	
		System.out.print("Enter the integers between 1 and 100: ");
		int maxx = 100;
	    int[] a = new int[maxx];
	    int[] b = new int[maxx];
	    int num , count=0;

	    for(int i = 1; i <= 100; i++){
	    	a[i] = 0;
	    }
	    for(int i = 0;; i++){
	    	num = input.nextInt();
	        if(num==0)
	            break;
	        if(a[num]==0){
	            b[count]=num;
	            count += 1;
	        }
	        a[num] += 1;
	     }
	    java.util.Arrays.sort(a,0,count);
	    for(int i = 0; i < count; i++){
	        if(a[b[i]] >= 1)
	            System.out.println(b[i] + " occurs " + a[b[i]] + " times");
	        else
	            System.out.println(b[i] + " occurs " + a[b[i]] + " times");
	    }
	}
}
