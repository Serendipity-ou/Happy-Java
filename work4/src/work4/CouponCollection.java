package work4;

import java.util.Scanner;

public class CouponCollection {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int maxx = 1000;
		int count1 = 0;
		int count2 = 0;
        String[] type1 = new String[maxx];
        String[] type2 = new String[maxx];
        int[] a = new int[maxx];
  
        for(int i = 0; i < 4; i++){
            a[i] = 0;
        }
        for(int i = 0; i < 4; i++){
            if(i==0) 
            	type1[i] = "Spades";
            else if(i==1) 
            	type1[i] = "Clubs";
            else if(i==2) 
            	type1[i] = "Hearts";
            else if(i==3) 
            	type1[i] = "Diamonds";
        }
        for(int i = 1; i <=13; i++){
            if(i == 1) 
            	type2[i] = "A";
            else if(i==2) 
            	type2[i] = "2";
            else if(i==3) 
            	type2[i] = "3";
            else if(i==4) 
            	type2[i] = "4";
            else if(i==5) 
            	type2[i] = "5";
            else if(i==6)
            	type2[i] = "6";
            else if(i==7) 
            	type2[i] = "7";
            else if(i==8) 
            	type2[i] = "8";
            else if(i==9) 
            	type2[i] = "9";
            else if(i==10) 
            	type2[i] = "10";
            else if(i==11) 
            	type2[i] = "Jack";
            else if(i==12) 
            	type2[i] = "Queen";
            else if(i==13) 
            	type2[i] = "King";
        }
        for(int i = 0;; i++) {
        	count1++;
        	int num1 = (int)(Math.random()*4);
        	int num2 = (int)(Math.random()*13 + 1);
        	if(a[num1] == 0) {
        		a[num1] += 1;
        		count2++;
        		System.out.println(type2[num2] + " of " + type1[num1]);
        	}
        	if(count2 == 4)
        	{
        		System.out.println("Number of picks: " + count1);
        		break;
        	}
        }
	}
}
