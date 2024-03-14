package p01;

import java.io.FileInputStream;
import java.io.InputStream;

public class TEST058 {
	public static void main(String[] args) throws Exception {
		InputStream in = new FileInputStream("C:\\JavaWork\\a.dat");
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
	}
}
