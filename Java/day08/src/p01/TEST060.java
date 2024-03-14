package p01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class TEST060 {
	public static void main(String[] args) throws Exception {
		long s = System.currentTimeMillis();
		InputStream in = new BufferedInputStream(new FileInputStream("C:\\JavaWork\\day1\\a.exe"));
		OutputStream out = new BufferedOutputStream(new FileOutputStream("C:\\JavaWork\\b.exe"));
		
		int l = 0;
		while((l = in.read()) != -1) {
			out.write(l);
		}
		
		long e = System.currentTimeMillis();
		System.out.println(e - s);
	}
}
