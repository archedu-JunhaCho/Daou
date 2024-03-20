package p04;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class TEST077 {
	public static void main(String[] args) throws Exception {
		Writer out = new FileWriter("data.txt");
		out.write('วั');
		
		Reader in = new FileReader("data.txt");
		int r = in.read();
		System.out.println((char)r);
		
		out.close();
		in.close();
	}
}
