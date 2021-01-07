package work7;

import java.util.Random;

public class UsingRandomClasses {
	public static void main(String[] args) {
		Random num = new Random(1000);
		System.out.println("The numbers are:");
		for(int i = 1; i <= 50; i++){
			int num1 = num.nextInt(100);
			System.out.print(num1 + " ");
			if(i % 10 == 0)
				System.out.println();
		}
	}
}
