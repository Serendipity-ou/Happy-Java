package week3;

import java.util.Scanner;
import java.lang.Math;

public class TwoCircles {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter circlel's center x-, y-coordinates, and radisu: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double r1 = input.nextDouble();
        System.out.print("Enter circle2's center x-, y-coordinates, and radius: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double r2 = input.nextDouble();
        
        double distanceR = Math.abs(r1 - r2);
        double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        
        if(distance <= distanceR)
        	System.out.println("circle2 is inside circle1");
        else if(distance <= (r1 + r2))
        	System.out.println("circle2 overlaps circle1");
        else
        	System.out.println("circle2 does not overlaps circle1");
	}
}