package work7;

import java.util.Scanner;

public class Equation {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入a、b和c的值： ");
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		QuadraticEquation result = new QuadraticEquation();
		
		if(result.getDiscriminant(a,b,c) > 0) {
			System.out.println("不同的两个根：");
			System.out.println("x1 = " + result.getRoot1(a,b,c));
			System.out.println("x2 = " + result.getRoot2(a,b,c));
		}
		else if(result.getDiscriminant(a,b,c) == 0)
			System.out.println("相同的两个根： x1 = x2 =" + result.getRoot1(a,b,c));
		else
			System.out.println("The equation has no roots.");
	}
}

class QuadraticEquation{
	private int a,b,c;
	
	public int getA(int a){
		return a;
	}
	
	public int getB(int b){
		return b;
	}
	
	public int getC(int c){
		return c;
	}
	
	public int getDiscriminant(int a, int b, int c){
		return b * b - 4 * a * c;
	}
	
	public double getRoot1(int a, int b, int c){
		if(getDiscriminant(a,b,c) >= 0)
			return ((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));
		else
			return 0;
	}
	
	public double getRoot2(int a, int b, int c){
		if(getDiscriminant(a,b,c) >= 0)
			return ((-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a));
		else
			return 0;
	}
}
