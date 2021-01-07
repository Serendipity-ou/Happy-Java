package work11;

import java.util.Scanner;

public class E1 {
	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
	     System.out.print("请输入身高（米）：");
	     double hh = input.nextDouble();
	     System.out.print("请输入体重（千克）：");
	     double kk = input.nextDouble();
	     BMI result = new Calculate(hh,kk);
	     System.out.print("您的bmi值是：" );
	     System.out.printf("%.2f",result.getBmi());
	}
}
abstract class BMI {
	public BMI(){
		super();
	}
	abstract double getBmi();
}
	
class Calculate extends BMI{
	private double hh;
	private double kk;

	Calculate(double hh, double kk) {
		this.hh = hh;
	    this.kk = kk;
	}

	@Override
	double getBmi() {
	    return kk / (hh * hh);
	}
}
