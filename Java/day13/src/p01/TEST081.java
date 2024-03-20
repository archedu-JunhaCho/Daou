// Http scan from url
package p01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TEST081 {
	public static void main(String[] args) throws Exception {
		URL l = new URL("https://m.nate.com/");
		HttpURLConnection uconn = (HttpURLConnection)l.openConnection();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(uconn.getInputStream(), "utf-8"));
		String t = null;
		while ((t = in.readLine()) != null) {
			System.out.println(" >> " + t);
		}
		in.close();
	}
}
