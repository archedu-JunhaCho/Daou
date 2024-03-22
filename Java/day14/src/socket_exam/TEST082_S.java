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
			
			// Ŭ���̾�Ʈ�κ��� �����͸� �а� ���� ���� ����� ��Ʈ�� ����
            BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
            PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
            
            // Ŭ���̾�Ʈ�κ��� ���� �����͸� �а� �ٽ� Ŭ���̾�Ʈ���� ����
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Ŭ���̾�Ʈ�κ��� ���� �޽���: " + message);
            }
			
			skt.close();
		}
		ss.close();
	}
}
