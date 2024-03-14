package p01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class TEST059 {
	public static void main(String[] args) throws Exception {
		InputStream in = new FileInputStream("C:\\JavaWork\\day1\\a.exe");
		OutputStream out = new FileOutputStream("C:\\JavaWork\\b.exe");
		
		byte[] buf = new byte[1024*16];
		int l = 0;
		while((l = in.read(buf)) != -1) {
			out.write(buf, 0, l);
		}
	}
}
