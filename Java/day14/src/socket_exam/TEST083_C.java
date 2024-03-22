// socket programming exam : input
package socket_exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.Socket;

public class TEST083_C {
	public static void main(String[] args) throws Exception {
		// setting
		Socket skt = new Socket("192.168.0.35", 7890);
		
		InputStream recv = skt.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(recv));
		
		String line;
        while ((line = in.readLine()) != null) {
            System.out.println("서버로부터 받은 데이터: " + line);
        }
		
		in.close();
		skt.close();
	}
}
