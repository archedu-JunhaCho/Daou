package p01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TEST062 {
	public static void main(String[] args) throws Exception {
		String path = "C:\\JavaWork\\c.dat";
		int[] data = new int[] {60, 80, 100, 75};
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path)
				);
		out.writeInt(data.length);
		for (int i = 0; i < data.length; i++) {
			out.writeInt(data[i]);
		}
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
		int len = in.readInt();
		for (int i = 0; i < len; i++) {
			System.out.println(in.readInt());
		}
		in.close();	
	}
}
