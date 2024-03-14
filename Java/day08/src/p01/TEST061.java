package p01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TEST061 {
	public static void main(String[] args) throws Exception{
		String path = "C:\\JavaWork\\b.dat";
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path)
				);
		out.writeInt( 12345 );
		out.writeDouble( 3.14 );
		out.writeUTF("오브젝트 저장입니다~!");
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
		System.out.println(in.readInt());
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		in.close();
	}
}
