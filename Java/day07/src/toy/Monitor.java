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
		intro.setText("<�������� �ý���>" + "\n �л��� : 0");
		output.setText("<���â>");
		// �ʱ� ����
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
						output.setText("<���â>\n" + "Success : add node value is \"" + data + "\"");
						now.add(data);
						return;
					}
				} catch(NumberFormatException error) {} 
			}
			output.setText("<���â>\n" +"Error : Input check (range : 0 ~ 100)");

		}
		else if (e.getSource() == btnDel) {
			System.out.println("<���â>\n" +"Click Delete!!!");
			String text = input.getText();
			if(!text.isEmpty()) {
				Integer idx = Integer.parseInt(text);
				boolean result = now.delete(idx);
				if (result) {
					output.setText("<���â>\n" +"Success : delete node idx is \"" + idx + "\"");
				}
				else {
					output.setText("<���â>\n" +"Fail : check idx \"" + idx + "\"");
				}
			}
			else {
				output.setText("<���â>\n" +"Error : Input Empty");
			}
		}
		else if (e.getSource() == btnPrint) {
			System.out.println("Click Print!!!");
			ArrayList<Integer> result = now.print();
			output.setText("<���â>\n" +result.toString());
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
		intro.setText("<�������� �ý���>" + "\n �л��� : 0");
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
		intro.setText("<�������� �ý���>" + "\n �л��� : " + allStudents.size());
		
		btnBack.setVisible(false);
		input.setVisible(false);
		btnAdd.setVisible(false);
		btnDel.setVisible(false);
		btnPrint.setVisible(false);
		btnRank.setVisible(false);
		output.setVisible(false);
	}
}