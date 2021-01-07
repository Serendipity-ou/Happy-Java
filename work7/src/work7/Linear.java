package work7;

import java.util.Scanner;

public class Linear {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("ÊäÈë a¡¢b¡¢c¡¢d¡¢e¡¢f£º");
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		int d = input.nextInt();
		int e = input.nextInt();
		int f = input.nextInt();

		LinearEquation result = new LinearEquation(a,b,c,d,e,f);
		if(result.isSolvable())
			System.out.println("x is " + result.getX() + " y is " + result.getY());
		else
			System.out.println("The equation has no solution.");
	}
}

class LinearEquation{
	private int a,b,c,d,e,f;
	
	public LinearEquation(int x1, int x2, int x3, int x4, int x5, int x6){
		a = x1;
		b = x2;
		c = x3;
		d = x4;
		e = x5;
		f = x6;
	}

	public int getA(int a){
		return a;
	}
	
	public int getB(int b){
		return b;
	}
	
	public int getC(int c){
		return c;
	}
	
	public int getD(int d){
		return d;
	}
	
	public int getE(int e){
		return e;
	}
	
	public int getF(int f){
		return f;
	}
	
	public boolean isSolvable(){
		if((a * d - b * c) != 0)
			return true;
		else
			return false;
	}
	
	public double getX(){
		return (e * d - b * f) / (a * d - b * c);
	}
	
	public double getY(){
		return (a * f - e * c)/(a * d - b * c);
	}
}
