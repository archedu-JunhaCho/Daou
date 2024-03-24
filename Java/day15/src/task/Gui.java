package task;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Font;
import java.awt.Color;

public class Gui {
	// Global Front items
	private JFrame frame;
	private Socket socket;
	private InputStream response = null;
	private OutputStream request = null;
	String result;
	/************** Main **************/
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/** thread-Back **/
					Thread backendThread = new Thread(new BackendHandler());
					backendThread.start();
					
					/** thread-Front **/
					Thread frontendThread = new Thread(new FrontendHandler());
					frontendThread.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/************** Front **************/
	private static void receiveFile(InputStream inputStream, int num) {
		int label = num+1;
        try {
        	String saveFilePath = "./store_client/song" + label + ".mp3";
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
		// constructor
		public FrontendHandler() throws Exception {
			System.out.println("<Front Open>");
        }
		// run
		@Override
		public void run(){
			try {
				// create Gui
				Gui window = new Gui();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/************** Back **************/
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

	/************** GUI 
	 * @wbp.parser.entryPoint**************/
	public Gui() throws Exception {
		initialize();
	}
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// textFields
		TextField connectField = new TextField();
		connectField.setBounds(22, 81, 151, 23);
		frame.getContentPane().add(connectField);
		
		// labels
		Label Title = new Label("< Sori Bada >");
		Title.setBackground(Color.WHITE);
		Title.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
		Title.setBounds(22, 10, 216, 32);
		frame.getContentPane().add(Title);
		Label conn_msg = new Label("result : ");
		conn_msg.setBackground(Color.WHITE);
		conn_msg.setBounds(22, 110, 216, 23);
		frame.getContentPane().add(conn_msg);
		Label List = new Label("< List >");
		List.setBackground(Color.WHITE);
		List.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 15));
		List.setBounds(22, 139, 216, 32);
		Label down_label1 = new Label("1. song1");
		down_label1.setBackground(Color.GRAY);
		down_label1.setBounds(22, 177, 216, 32);
		Label down_label2 = new Label("2. song2");
		down_label2.setBackground(Color.GRAY);
		down_label2.setBounds(22, 215, 216, 32);
		Label down_label3 = new Label("3. song3");
		down_label3.setBackground(Color.GRAY);
		down_label3.setBounds(22, 253, 216, 32);
		Label down_label4 = new Label("4. song4");
		down_label4.setBackground(Color.GRAY);
		down_label4.setBounds(22, 291, 216, 32);
		Label down_label5 = new Label("5. song5");
		down_label5.setBackground(Color.GRAY);
		down_label5.setBounds(22, 329, 216, 32);
		Label label_1_1_1 = new Label("0 %");
		label_1_1_1.setBackground(Color.WHITE);
		label_1_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		label_1_1_1.setBounds(322, 398, 47, 32);
		Label msg1 = new Label("Please Enter Url + Port");
		msg1.setBackground(Color.WHITE);
		msg1.setBounds(22, 48, 216, 32);
		frame.getContentPane().add(msg1);

		// buttons
		Button down_btn1 = new Button("Download");
		down_btn1.setBounds(244, 177, 86, 32);
		Button down_btn2 = new Button("Download");
		down_btn2.setBounds(244, 215, 86, 32);
		Button down_btn3 = new Button("Download");
		down_btn3.setBounds(244, 253, 86, 32);
		Button down_btn4 = new Button("Download");
		down_btn4.setBounds(244, 291, 86, 32);
		Button down_btn5 = new Button("Download");
		down_btn5.setBounds(244, 329, 86, 32);
	    addDownloadButton(down_btn1, 0);
	    addDownloadButton(down_btn2, 1);
	    addDownloadButton(down_btn3, 2);
	    addDownloadButton(down_btn4, 3);
	    addDownloadButton(down_btn5, 4);
		
	    // panels
		Panel panel = new Panel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(22, 407, 23, 23);
		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(51, 407, 23, 23);
		Panel panel_2 = new Panel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(80, 407, 23, 23);
		Panel panel_3 = new Panel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(109, 407, 23, 23);
		Panel panel_4 = new Panel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(138, 407, 23, 23);
		Panel panel_5 = new Panel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(167, 407, 23, 23);
		Panel panel_6 = new Panel();
		panel_6.setBackground(Color.LIGHT_GRAY);
		panel_6.setBounds(196, 407, 23, 23);
		Panel panel_7 = new Panel();
		panel_7.setBackground(Color.LIGHT_GRAY);
		panel_7.setBounds(225, 407, 23, 23);
		Panel panel_8 = new Panel();
		panel_8.setBackground(Color.LIGHT_GRAY);
		panel_8.setBounds(254, 407, 23, 23);
		Panel panel_9 = new Panel();
		panel_9.setBackground(Color.LIGHT_GRAY);
		panel_9.setBounds(283, 407, 23, 23);
		
		// add things
		frame.getContentPane().add(List);
		frame.getContentPane().add(down_label1);
		frame.getContentPane().add(down_label2);
		frame.getContentPane().add(down_label3);
		frame.getContentPane().add(down_label4);
		frame.getContentPane().add(down_btn1);
		frame.getContentPane().add(down_btn2);
		frame.getContentPane().add(down_btn3);
		frame.getContentPane().add(down_btn4);
		frame.getContentPane().add(down_btn5);
		down_btn1.setEnabled(false);
		down_btn2.setEnabled(false);
		down_btn3.setEnabled(false);
		down_btn4.setEnabled(false);
		down_btn5.setEnabled(false);
		frame.getContentPane().add(down_label5);
		frame.getContentPane().add(panel);
		frame.getContentPane().add(panel_1);
		frame.getContentPane().add(panel_2);
		frame.getContentPane().add(panel_3);
		frame.getContentPane().add(panel_4);
		frame.getContentPane().add(panel_5);
		frame.getContentPane().add(panel_6);
		frame.getContentPane().add(panel_7);
		frame.getContentPane().add(panel_8);
		frame.getContentPane().add(panel_9);
		frame.getContentPane().add(label_1_1_1);
		
		Button connect_btn = new Button("Connect");
		connect_btn.setBounds(179, 81, 86, 23);
		frame.getContentPane().add(connect_btn);
		connect_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String urlAndPort = connectField.getText();
    			String total = urlAndPort;
    			String url = total.split(":")[0];
    			String port = total.split(":")[1];
    			try {
					socket = new Socket(url, Integer.valueOf(port));
					conn_msg.setText("result : 200 Success");
					response = socket.getInputStream();
					request = socket.getOutputStream();
					down_btn1.setEnabled(true);
					down_btn2.setEnabled(true);
					down_btn3.setEnabled(true);
					down_btn4.setEnabled(true);
					down_btn5.setEnabled(true);
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
					conn_msg.setText("result : 404 Not Found");
					down_btn1.setEnabled(false);
					down_btn2.setEnabled(false);
					down_btn3.setEnabled(false);
					down_btn4.setEnabled(false);
					down_btn5.setEnabled(false);
				}
    			System.out.println("<Success>");
            }
        });
	}
	private void addDownloadButton(Button button, int index) {
	    button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            if (request != null) {
	                try {
	                    request.write(index);
	                    request.flush();
	                    
	                    System.out.println("   >> Front : Save Start");
	                    receiveFile(response, index);
	                } catch (IOException e1) {
	                    e1.printStackTrace();
	                }
	            }
	        }
	    });
	}
}
