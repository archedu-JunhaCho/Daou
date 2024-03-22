package socket_exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TEST083_S {
	public static void main(String[] args) throws Exception{
		// setting
		ServerSocket ss = new ServerSocket(7890);
		Socket skt = ss.accept();
		System.out.println("Server Open");
		
		// send
		String url = "C:\\Users\\TECH2-16\\Desktop\\socket.txt";
		BufferedReader in = new BufferedReader(new FileReader(url));
		PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
		String t = null;
		while((t = in.readLine()) != null) {
			out.println(t);
		}
		
		// End
		out.close();
		in.close();
		skt.close();
		ss.close();
	}
}
