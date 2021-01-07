package week3;

import java.util.Scanner;
import java.lang.Math;

public class TwoRectangles {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter rl's center x-, y-coordinates, width, and height: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double w1 = input.nextDouble();
        double h1 = input.nextDouble();
        System.out.print("Enter r2's center x-, y-coordinates, width, and height: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double w2 = input.nextDouble();
        double h2 = input.nextDouble();
        
        var distancex = Math.abs(x1 - x2);
        var distancey = Math.abs(y1 - y2);
        var distancew1 = Math.abs(w1 - w2) / 2;
        var distanceh1 = Math.abs(h1 - h2) / 2;
        var distancew2 = Math.abs(w1 + w2) / 2;
        var distanceh2 = Math.abs(h1 + h2) / 2;
        
        if(distancex < distancew1 && distancey < distanceh1)
        	System.out.println("r2 is inside r1");
        else if(distancex < distancew2 && distancey < distanceh2)
        	System.out.println("r2 overlaps r1");
        else
        	System.out.println("r2 does not overlaps r1");
	}
}
