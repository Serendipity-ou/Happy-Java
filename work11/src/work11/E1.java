package work11;

import java.util.Scanner;

public class E1 {
	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
	     System.out.print("��������ߣ��ף���");
	     double hh = input.nextDouble();
	     System.out.print("���������أ�ǧ�ˣ���");
	     double kk = input.nextDouble();
	     BMI result = new Calculate(hh,kk);
	     System.out.print("����bmiֵ�ǣ�" );
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
