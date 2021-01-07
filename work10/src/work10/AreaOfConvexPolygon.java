package work10;

import java.util.*;

public class AreaOfConvexPolygon {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of the points: ");
		int points = input.nextInt();
		System.out.println("Enter the coordinates of the points: ");
		float[] X = new float[points];
		float[] Y = new float[points];
		
		for(int i = 0; i < points; i++) {
			X[i] = input.nextFloat();
			Y[i] = input.nextFloat();
		}
		
		float area = 0;
		for(int i = 0;i < points - 1; i++)
	        	area += X[i] * Y[i+1] - X[i+1] * Y[i];
		area += X[points-1] * Y[0] - X[0] * Y[points-1];
		
		area=Math.abs(area)/2;
		System.out.println("The area is " + area);
	}
}
