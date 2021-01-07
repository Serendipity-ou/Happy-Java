package week3;

import java.util.Scanner;

public class IsItInsideTheTriangle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a point's x- and y-coordinates: ");
		double x = input.nextDouble(); 
		double y = input.nextDouble(); 
		
		if(x >= 0 && x <= 200 && y <= -0.5 * x + 100)
			System.out.println("The point is in the circle");
		else
			System.out.println("The point is not in the circle");
	}
}
