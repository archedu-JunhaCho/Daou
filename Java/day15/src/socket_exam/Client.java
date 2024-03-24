// client - socket Thread
package socket_exam;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception {
		/** setting **/ 
		Socket skt = new Socket("192.168.0.35", 7890);
		System.out.println("<Open Client>");
		
		/** send thread **/ 
		Thread sendThread = new Thread(new SendHandler(skt));
		sendThread.start();
        
		/** recv thread **/ 
        Thread recvThread = new Thread(new RecvHandler(skt));
        recvThread.start();
	}
	
	static class SendHandler implements Runnable{
		// setting
		private Socket socket;
		private ObjectOutputStream clientOut;
		private Request request;
		Scanner scanner = new Scanner(System.in);
			
		// constructor
		public SendHandler(Socket socket) throws Exception {
            this.socket = socket;
            this.clientOut = new ObjectOutputStream(socket.getOutputStream());
            this.request = new Request();
            System.out.println("  -> send thread open");
        }
		
		// run
		@Override
		public void run() {
			Boolean run_send = true;
			// send logic loop
			while(run_send) {
				try {
					// sample logic
					Integer select = scanner.nextInt();
					if(select == 1) {
						request.put("test", "send");
						// send
						clientOut.writeObject(request);
						clientOut.flush();
					}
				} 
				catch (Exception e) {
					System.out.println("send error");
					e.printStackTrace();
					break;
				}
			}
			// send logic end -> close socket
			try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
		 
	 }
	
	static class RecvHandler implements Runnable {
		// setting
		private Socket socket;
		private ObjectInputStream clientIn;
		private Response response;
			
		// constructor
		public RecvHandler(Socket socket) throws Exception {
            this.socket = socket;
            System.out.println("  -> recv thread open");
            this.clientIn = new ObjectInputStream(socket.getInputStream());
        }
		
		// run
		@Override
		public void run() {
			Boolean run_recv = true;
			// recv logic loop
			while(run_recv) {
				try {
					response = (Response)clientIn.readObject();
					System.out.println("\nRES: " + response.toString());
				} 
				catch (Exception e) {
					System.out.println("recv error");
					e.printStackTrace();
					break;
				}
			}
			// recv logic end -> close socket
			try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
		 
	 }
	 
}
