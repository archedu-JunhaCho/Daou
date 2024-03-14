package p01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class TEST057 {
	public static void main(String[] args) throws Exception {
		OutputStream out = new FileOutputStream("C:\\JavaWork\\a.dat");
		out.write(100);
		out.write(101);
		out.write(102);
		out.write(103);
	}
}
