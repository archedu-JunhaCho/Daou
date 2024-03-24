// client will recv mp3 file
package mp3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception {
		/** setting **/
		Socket skt = new Socket("192.168.0.35", 7890);
		Boolean run = true;
		OutputStream request = skt.getOutputStream();
		InputStream response = skt.getInputStream();
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		
		/** run **/
		while(run) {
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
            System.out.println("    >> Receiving file...");
            receiveFile(response, fileNumber);
		}
		
		/** exit **/
		System.out.println("Client exit");
		skt.close();
		userInput.close();
		response.close();
		request.close();
		
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
            System.out.println(" -> Save Success");
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
