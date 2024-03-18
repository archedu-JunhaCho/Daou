package exception;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TEST069 {
	public static void main(String[] args) throws IOException{
		DataOutputStream ot = null;
		DataInputStream it = null;
		try {
			ot = new DataOutputStream(new FileOutputStream("C:\\JavaWork\\a.dat"));
			ot.writeInt(44);
			ot.writeInt(55);
			
			it = new DataInputStream(new FileInputStream("C:\\JavaWork\\a.dat"));
			it.close();
		} catch (IOException e) {
			
		} finally {
			if(ot != null) ot.close();
		}
	}
}
