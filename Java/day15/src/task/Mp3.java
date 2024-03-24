// client will recv mp3 file
package task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Mp3 {
	public static void main(String[] args) throws Exception {
		
	}
	
	private static void receiveFile(InputStream inputStream, int num) {
        try {
        	String saveFilePath = "./store_client/" + num + ".mp3";
            File file = new File(saveFilePath);
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
            	//System.out.println("  >> byte : " + bytesRead);
                fileOutputStream.write(buffer, 0, bytesRead);
                if(bytesRead != 8192) {
                	break;
                }
            }
            System.out.println("   >> Front : Save Success");
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	static class FrontendHandler implements Runnable {
		// setting
		private Socket socket;
		private InputStream response;
		private OutputStream request;
		private BufferedReader userInput;
		String result;
		
		// constructor
		public FrontendHandler(String url_input) throws Exception {
			this.userInput = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("<Front Open>");
			System.out.println("  >> Enter Url + Port");
			System.out.println("  >> ex. 127.0.0.1:7890");
			System.out.print("  >> : ");
			
			String total = url_input;
			String url = total.split(":")[0];
			String port = total.split(":")[1];
			this.socket = new Socket(url, Integer.valueOf(port));
			System.out.println("<Success>");
        }
		
		// run
		@Override
		public void run() {
			try {
	            this.response = socket.getInputStream();
	    		this.request = socket.getOutputStream();
	    		
	    		Boolean run_server = true;
	    		while(run_server) {
	    			try {
	    				// 1. input select
	    				System.out.print("Select num (0 ~ 4): ");
	    				int fileNumber = Integer.parseInt(userInput.readLine());
	    				if (fileNumber < 0 || fileNumber > 4) {
	    					continue;
	    				}
	    				
	    				// 2. run each func
	    				request.write(fileNumber);
	    				request.flush();
	    				
	    				// 3. recv response
	    				System.out.println("   >> Front : Save Start");
	    				receiveFile(response, fileNumber);
	    			} 
	    			catch (Exception e) {
	    				e.printStackTrace();
	    				break;
	    			}
	    		}
	    		try {
	    			System.out.println("Client exit");
	    			socket.close();
	    			userInput.close();
	    			response.close();
	    			request.close();
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
	
	static class BackendHandler implements Runnable {
		// setting
		private InputStream request;
		private OutputStream response;
		private ServerSocket ss;
		String result;
		
		// constructor
		public BackendHandler() throws Exception {
			System.out.println("<Back Open>");
			this.ss = new ServerSocket(7890);
        }
		
		// run
		@Override
		public void run() {
			try {
				Socket socket = ss.accept();
	            request = socket.getInputStream();
	    		response = socket.getOutputStream();
	    		
				Boolean run_server = true;
				while(run_server) {
					try {
						// 1. wait request
						int select = request.read();
						System.out.println("   >> Back : File send start");
						if (select == 255) {
							System.out.println("<Exit>");
							response.close();
							request.close();
							break;
						}
						// 2. run each func
						sendFile(response, select);
						System.out.println("   >> Back : File sent successfully.");
					} 
					catch (Exception e) {
						e.printStackTrace();
						break;
					}
				}
				
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}
	}
	
}
