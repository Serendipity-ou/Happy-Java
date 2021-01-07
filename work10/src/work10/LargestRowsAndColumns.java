package work10;

import java.util.Scanner;

public class LargestRowsAndColumns {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the array size n: ");
		int n = input.nextInt();
		System.out.println("The random array is");
		
		int[][] lst = new int[n][n];
		
		 for(int i = 0; i < n; i++){
			 for(int j = 0; j < n; j++){
				 lst[i][j] = (int)(Math.random() * 2);
	             System.out.print(lst[i][j]);
	         }
	         System.out.println("");
	        }
		 
		 int max_r = 0;
		 int[] index_r = new int[n];
		 
		 for(int i = 0; i < n; i++){
			 int count_r = 0;
	         for(int j = 0; j < n; j++){
	            if(lst[i][j] == 1)
	            	count_r += 1;
	         }
	         index_r[i] = count_r;
	         if(count_r > max_r)
	        	 max_r = count_r;
	     }
		 
		 int max_c = 0;
		 int[] index_c = new int[n];
		 
		 for(int j = 0; j < n; j++){
			 int count_c = 0;
	         for(int i = 0; i < n; i++){
	            if(lst[i][j] == 1)
	            	count_c += 1;
	         }
	         index_c[j] = count_c;
	         if(count_c > max_c)
	        	 max_c = count_c;
	     }
		 
		 System.out.print("The largest row index: ");
		 for(int i = 0; i < n; i++) {
			 if(index_r[i] == max_r)
				 System.out.print(i + " ");
		 }
		 System.out.println("");
		 System.out.print("The largest column index: ");
		 for(int j = 0; j < n; j++) {
			 if(index_c[j] == max_c)
				 System.out.print(j + " ");
		 }
	}
}
