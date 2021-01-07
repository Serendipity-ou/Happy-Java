package work9;

public class Example {
	public static void main(String[] args) {
	      Day(new Sunday());      
	  }       
	public static void Day(Weather a)  {
		a.play1();  
		if (a instanceof Sunday)  {
			Sunday c = (Sunday)a;  
			c.play2();  
		} 
	}
}

abstract class Weather {  
    abstract void play1();  
}  
class Sunday extends Weather {  
    public void play1() {  
        System.out.println("∑≈∑ÁÛ›");  
    }  
    public void play2() {  
        System.out.println("”Œ”æ");  
    }  
}  