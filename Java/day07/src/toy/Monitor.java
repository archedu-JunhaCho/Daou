package toy;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Monitor extends Frame implements ActionListener {
	ArrayList<Linked> allStudents = new ArrayList<>();
	Linked now;
	// create button
	Button btnStudent = new Button("New Student");
	Button btnBack = new Button("back");
	Button btnAdd = new Button("add");
	Button btnDel = new Button("del");
	Button btnPrint = new Button("print");
	Button btnRank = new Button("rank");
	Button btnExit = new Button("Exit");
	TextField input = new TextField(20);
	JTextArea intro = new JTextArea(10, 20);
	JTextArea output = new JTextArea(10, 20);
	// construct
	Monitor (){
		// monitor setting
		setSize(400, 300);
		setLayout(new FlowLayout());
		// monitor action
		btnStudent.addActionListener(this);
		btnBack.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnPrint.addActionListener(this);
		btnRank.addActionListener(this);
		btnExit.addActionListener(this);
		output.setEditable(false);
		add(btnStudent);
		add(btnExit);
		add(btnBack);
		add(input);
		add(btnAdd);
		add(btnDel);
		add(btnPrint);
		add(btnRank);
		add(output);
		add(intro);
		intro.setText("<성적관리 시스템>" + "\n 학생수 : 0");
		output.setText("<결과창>");
		// 초기 세팅
		toggleHome();
	}
	// Function
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStudent) {
			now = new Linked();
			allStudents.add(now);
			toggleInput();
		}
		else if (e.getSource() == btnBack) {
			toggleSwitch();
		}
		else if (e.getSource() == btnAdd) {
			System.out.println("Click Add!!!");
			String text = input.getText();
			if(!text.isEmpty()) {
				try {
					Integer data = Integer.parseInt(text);
					if(data >= 0 && data <= 100) {
						output.setText("<결과창>\n" + "Success : add node value is \"" + data + "\"");
						now.add(data);
						return;
					}
				} catch(NumberFormatException error) {} 
			}
			output.setText("<결과창>\n" +"Error : Input check (range : 0 ~ 100)");

		}
		else if (e.getSource() == btnDel) {
			System.out.println("<결과창>\n" +"Click Delete!!!");
			String text = input.getText();
			if(!text.isEmpty()) {
				Integer idx = Integer.parseInt(text);
				boolean result = now.delete(idx);
				if (result) {
					output.setText("<결과창>\n" +"Success : delete node idx is \"" + idx + "\"");
				}
				else {
					output.setText("<결과창>\n" +"Fail : check idx \"" + idx + "\"");
				}
			}
			else {
				output.setText("<결과창>\n" +"Error : Input Empty");
			}
		}
		else if (e.getSource() == btnPrint) {
			System.out.println("Click Print!!!");
			ArrayList<Integer> result = now.print();
			output.setText("<결과창>\n" +result.toString());
		}
		else if (e.getSource() == btnRank) {
			System.out.println("Click Rank!!!");
			now.rank();
		}
		else if (e.getSource() == btnExit) {
			System.out.println("Click Exit!!!");
			dispose();
		}
		
	}
	public void toggleHome() {
		btnBack.setVisible(false);
		input.setVisible(false);
		btnAdd.setVisible(false);
		btnDel.setVisible(false);
		btnPrint.setVisible(false);
		btnRank.setVisible(false);
		output.setVisible(false);
		intro.setText("<성적관리 시스템>" + "\n 학생수 : 0");
		pack();
	}
	public void toggleInput() {
		btnStudent.setVisible(false);
		btnBack.setVisible(true);
		intro.setVisible(false);
		input.setVisible(true);
		btnAdd.setVisible(true);
		btnDel.setVisible(true);
		btnPrint.setVisible(true);
		btnRank.setVisible(true);
		output.setVisible(true);
		pack();
	}
	public void toggleSwitch() {
		btnStudent.setVisible(true);
		intro.setVisible(true);
		intro.setText("<성적관리 시스템>" + "\n 학생수 : " + allStudents.size());
		
		btnBack.setVisible(false);
		input.setVisible(false);
		btnAdd.setVisible(false);
		btnDel.setVisible(false);
		btnPrint.setVisible(false);
		btnRank.setVisible(false);
		output.setVisible(false);
	}
}