package work7;

import java.util.Date;

public class UseDateClass {
	public static void main(String[] args){
		int num = 10000;
		Date date = new Date(num);
		for(int i = 0; i < 8; i++){
			long num1 = num * (long)(Math.pow(10, i));
			date.setTime(num1);
			System.out.println(date.toString());
		}
	}
}
