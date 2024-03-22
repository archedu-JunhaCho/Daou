package socket_exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TEST082_C {
	public static void main(String[] args) throws Exception {
		// setting
		Socket skt = new Socket("192.168.0.35", 7890);
		
		// do task
		BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
		PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
		out.println("안녕하세요, 서버!");
		
		skt.close();
	}
}
