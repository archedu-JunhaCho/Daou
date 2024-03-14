package toy;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// setting
		Frame fm = new Frame();
		List<Button> buttonList = new ArrayList<>();
		fm.setSize(300, 400);
		fm.setLayout(new FlowLayout());
		// load function
		btnSetting(fm, buttonList);
		// start
		fm.setVisible(true);
	}
	public static void btnSetting(Frame fm, List<Button> buttonList) {
		// 1
		Button btnAddStudent = new Button("New Student");
		btnAddStudent.addActionListener(e->{
			
		});
		buttonList.add(btnAddStudent);
		// 2
		Button btnExit = new Button("Exit");
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buttonList.add(btnExit);
		
		fm.add(new Button("Back"));
		fm.add(new Button("Add"));
		fm.add(new Button("Delete"));
		fm.add(new Button("Print"));
	}
	public static void addFunc() {
		
	}
}
