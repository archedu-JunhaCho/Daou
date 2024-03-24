// server will send mp3 file
package mp3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	public static void main(String[] args) throws Exception {
		/** setting **/
		System.out.println("<Server Open>");
		ServerSocket ss = new ServerSocket(7890);
		Boolean run_server = true;
		
		/** run **/
		try {
			while(run_server) {
				Socket socket = ss.accept();
				System.out.println(" >> Connect : " + socket);
				
				Thread clientThread = new Thread(new ClientHandler(socket));
				clientThread.start();
			}
		}
		catch (Exception e){
			ss.close();
			e.getStackTrace();
		}
		
		/** exit **/
		ss.close();
	}
	
	private static void sendFile(OutputStream outputStream, int select) {
		String fileRoot = "./store_server/mp3/";
		String[] fileNum = {"1202", "1209", "1216", "1223", "1225"};
        try {
            File file = new File(fileRoot+fileNum[select]+".mp3");
            FileInputStream fileInputStream = new FileInputStream(file);
            
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            fileInputStream.close();
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	static class ClientHandler implements Runnable {
		// setting
		private Socket socket;
		private InputStream request;
		private OutputStream response;
		String result;
		
		// constructor
		public ClientHandler(Socket socket) throws Exception {
            this.socket = socket;
            this.request = socket.getInputStream();
    		this.response = socket.getOutputStream();
        }
		
		// run
		@Override
		public void run() {
			Boolean run_server = true;
			while(run_server) {
				try {
					// 1. wait request
					int select = request.read();
					System.out.println("   >> client send" + select);
					if (select == 255) {
						System.out.println("<Exit>");
						response.close();
						request.close();
						break;
					}
					// 2. run each func
					sendFile(response, select);
					System.out.println("   >> File sent successfully.");
				} 
				catch (Exception e) {
					e.printStackTrace();
					break;
				}
			}
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
