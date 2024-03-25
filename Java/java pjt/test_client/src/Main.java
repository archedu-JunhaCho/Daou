// client - socket Thread

import controller.RecvController;
import controller.SendController;
import java.net.Socket;


public class Main {
    public static void main(String[] args) throws Exception {
        /** setting **/
        Socket socket = new Socket("127.0.0.1", 7890);
        System.out.println("<Open Client>");

        /** send thread **/
        Thread sendThread = new Thread(new SendController(socket));
        sendThread.start();

        /** recv thread **/
        Thread recvThread = new Thread(new RecvController(socket));
        recvThread.start();
    }
}
