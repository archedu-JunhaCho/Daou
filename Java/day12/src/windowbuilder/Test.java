package windowbuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.ScrollPane;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.List;
import java.awt.TextField;
import java.awt.Scrollbar;

public class Test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 743, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Button button = new Button("New button");
		button.setBounds(34, 20, 69, 23);
		frame.getContentPane().add(button);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(112, 124, 440, 170);
		frame.getContentPane().add(textArea);
		
		Label label = new Label("New label");
		label.setBounds(167, 41, 69, 23);
		frame.getContentPane().add(label);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(584, 40, 100, 264);
		frame.getContentPane().add(scrollPane);
		
		Checkbox checkbox = new Checkbox("New check box");
		checkbox.setBounds(57, 65, 101, 23);
		frame.getContentPane().add(checkbox);
		
		Choice choice = new Choice();
		choice.setBounds(370, 43, 28, 21);
		frame.getContentPane().add(choice);
		
		List list = new List();
		list.setBounds(428, 24, 124, 64);
		frame.getContentPane().add(list);
		
		TextField textField = new TextField();
		textField.setBounds(275, 65, 81, 23);
		frame.getContentPane().add(textField);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(57, 198, 17, 50);
		frame.getContentPane().add(scrollbar);
	}
}
