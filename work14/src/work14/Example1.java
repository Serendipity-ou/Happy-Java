package work14;

import java.io.*;

public class Example1 {
	public static void main(String[] args) throws IOException{
		File file_in = new File("example.txt");
        
        try (PrintWriter output = new PrintWriter(file_in);) {
			output.println("Hello Java!!!");
		}
	}
}
