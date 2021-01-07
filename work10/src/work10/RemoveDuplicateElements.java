package work10;

import java.util.*;

public class RemoveDuplicateElements {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter ten integers: ");
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++)
            lst.add(input.nextInt());
        System.out.print("The distinct integers are ");
        
        removeDuplicate(lst);
        
        for(int i=0; i<10; i++) 
        	System.out.print(lst.get(i) + " ");
	}
	
	public static void removeDuplicate(ArrayList<Integer> list) {
		ArrayList<Integer> n = new ArrayList<Integer>();
	    int L = list.size();
	    for(int i = 0; i < L; i++) {
	    	if(!n.contains(list.get(i)))
	    		n.add(list.get(i));
	    }
	    
	    list.clear();
	    int L1 = n.size();
	    for(int i =0; i < L1; i++) {
	    	list.add(n.get(i));
	    }
	}
}
