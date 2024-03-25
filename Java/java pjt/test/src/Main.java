// Server - socket Thread

import controller.ClientController;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws Exception {
        /** setting **/
        boolean run = true;
        ServerSocket ss = new ServerSocket(7890);
        System.out.println("<Open Server>");

        /** run **/
        while(run) {
            // recv thread
            Socket socket = ss.accept();
            System.out.println("  client -> " + socket);
            Thread clientThread = new Thread(new ClientController(socket));
            clientThread.start();
        }

        /** exit **/
        ss.close();
    }
}
