package work4;

import java.util.Scanner;
import java.util.Arrays;

public class CharacterOrderingInStrings {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("×Ö·û´®£º");
		String str = input.next();
		System.out.print("ÅÅÐòºóµÄ×Ö·û´®£º" + sort(str));
	}
	
	private static String sort(String s) {
	    char[] list = new char[s.length()];
	    int L = list.length;
	    String SS = "";
	    
	    for (int i = 0; i < L; i++) {
	        if (i != L - 1) 
	        	list[i] = s.substring(i, i + 1).charAt(0);
	        else 
	        	list[i] = s.substring(i).charAt(0);
	    }
	    Arrays.sort(list);
	    for (char ch : list) 
	        SS += String.valueOf(ch);
	    return SS;
	}
}