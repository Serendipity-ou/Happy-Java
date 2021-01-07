package week3;

import java.util.Scanner;

public class CircumferenceOfTriangle {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
		
	double a = input.nextDouble();
    double b = input.nextDouble();
    double c = input.nextDouble();
        
    double total = a + b + c;
        
    if(a+b>c && a+c>b && b+c>a)
    	System.out.println("The circumference of triangle is " + total);
    else
        System.out.println("These inputs are illegal");
	}
}
