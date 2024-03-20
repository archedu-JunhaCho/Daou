// IO input ver 1
package p01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TEST079 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String t = null;
		
		while ((t = in.readLine()) != null) {
			System.out.println(" >> " + t);
		}
		in.close();
	}
}
