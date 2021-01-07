package work4;

import java.util.Scanner;

public class LockerProblems {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        int maxx = 1000;
        int[] a = new int[maxx];
        
        for(int i = 1; i <= 100; i++){
            a[i] = -1;
        }
        for(int i = 1; i <= 100; i++){
            for(int j = i; j <= 100; j += i){
                a[j] = -a[j];
            }
        }
        System.out.print("打开的柜子：");
        for(int i = 1; i <= 100; i++){
            if(a[i] == 1)
                System.out.print(i + " ");
        }
	}
}
