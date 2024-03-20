package p04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TEST078 {
	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter("data2.txt"));
		out.println("¾È³ç¾È³ç");
		out.println("¹æ°¡ ¹æ°¡");
		out.close();
		
		BufferedReader in = new BufferedReader(new FileReader("data2.txt"));
		System.out.println(in.readLine());
		System.out.println(in.readLine());
		System.out.println(in.readLine());
		
		in.close();
	}
}
