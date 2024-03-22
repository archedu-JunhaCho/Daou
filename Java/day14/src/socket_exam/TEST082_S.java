package socket_exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TEST082_S {
	public static void main(String[] args) throws Exception {
		// setting
		Boolean run = true;
		ServerSocket ss = new ServerSocket(7890);
		System.out.println("Server Open");
		
		// thread
		while(run) {
			Socket skt = ss.accept();
			System.out.println("after" + " >> " + skt);
			
			// 클라이언트로부터 데이터를 읽고 쓰기 위한 입출력 스트림 생성
            BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
            PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
            
            // 클라이언트로부터 받은 데이터를 읽고 다시 클라이언트에게 보냄
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("클라이언트로부터 받은 메시지: " + message);
            }
			
			skt.close();
		}
		ss.close();
	}
}
