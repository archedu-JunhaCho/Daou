// IO input ver2
package p01;

import java.util.Scanner;

public class TEST080 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String t = null;
		
		while ((t = scan.nextLine()) != null) {
			System.out.println(" >> " + t);
		}
		scan.close();
	}
}
