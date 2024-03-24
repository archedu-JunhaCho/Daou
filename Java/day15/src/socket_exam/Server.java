// Server - socket Thread
package socket_exam;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		/** setting **/ 
		Boolean run = true; 
		ServerSocket ss = new ServerSocket(7890);
		System.out.println("<Open Server>");
		
		/** run **/ 
		while(run) {
			// recv thread
			Socket skt = ss.accept();
			System.out.println("  ���� -> " + skt);
			Thread clientThread = new Thread(new ClientHandler(skt));
            clientThread.start();
		}
		
		/** exit **/ 
		ss.close();
	}
	
	static class ClientHandler implements Runnable {
		// setting
		private Socket socket;
		private Request request;
		private Response response;
		private ObjectInputStream serverIn;
		private ObjectOutputStream serverOut;
		String result;
		
		// constructor
		public ClientHandler(Socket socket) throws Exception {
            this.socket = socket;
            this.response = new Response();
            this.serverOut = new ObjectOutputStream(socket.getOutputStream());
            this.serverIn = new ObjectInputStream(socket.getInputStream());
        }
		
		// run
		@Override
		public void run() {
			Boolean run_server = true;
			while(run_server) {
				try {
					// request
					request = (Request)serverIn.readObject();
					System.out.println("\nREQ\n"+socket + request.toString());
					
					// response
					response.put("msg", "Success");
					serverOut.writeObject(response);
					serverOut.flush();
				} 
				catch (Exception e) {
					e.printStackTrace();
					break;
				}
			}
		}
		
	}
}
