package work14;

import java.io.*;

public class Example2 {
	public static void main(String[] args) throws IOException {
		InputStream file1 = new FileInputStream("example1.txt");
        OutputStream file2 = new FileOutputStream("example2.txt");
        int i;
        while((i = file1.read()) != -1)
            file2.write(i);
        file2.close();
	}
}
