package p02;

import java.awt.Button;
import java.awt.Frame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FrameApple extends Frame implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("Click!!!");
	}
	
	FrameApple (){
		// setting
		setSize(400, 300);
		setLayout(new FlowLayout());
		// create button
		Button btnClick = new Button("Click");
		btnClick.addActionListener(this);
		add(btnClick);
	}
}

public class TEST055 {
	public static void main(String[] args) {
		FrameApple f = new FrameApple();
		f.setVisible(true);
	}
}
