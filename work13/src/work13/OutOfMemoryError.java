package work13;

import java.util.*;

public class OutOfMemoryError {
	public static void main(String[] args) {
		List lst=new ArrayList();
    	try {
			while(true) 
				lst.add(new Object());
		} 
    	catch (Exception e) {
    		System.out.println(e);
		}
    }
}
