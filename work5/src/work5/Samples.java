package work5;

import java.util.regex.*;
import java.util.Scanner;

public class Samples {
	public static void main(String[] args) {
		Scanner S1 = new Scanner(System.in);
        System.out.println("ÇëÊäÈëÊÖ»úºÅÂë£º");
        String S2 = S1.nextLine();

        String regex = "1[79]\\d{9}";
        boolean flag = S2.matches(regex);
        System.out.println(flag);
	}
}
