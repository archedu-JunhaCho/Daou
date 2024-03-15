package group;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.util.Random;

import javax.swing.JTextArea;

public class Main {
	public static void main(String[] args) {
		String name[] = {"김영우","김상원","박광효","조준하","황한울","심다은","전채은","박성민","유재호","정의석","윤강석","김병준","조완규","김인태","이승찬"};
		Frame fm = new Frame();
		Button click = new Button("DAOU RANDOM");
		TextField tf = new TextField();
		JTextArea result = new JTextArea();
		fm.setSize(400, 300);
		tf.setSize(20, 20);
		result.setSize(400, 100);
		fm.setLayout(new FlowLayout());
		click.addActionListener(e->{
			randomSelect(result, name, tf);
		});
		fm.add(tf);
		fm.add(click);
		fm.add(result);
		fm.setVisible(true);
	}
	// 랜덤 고르기
	public static void randomSelect(JTextArea result, String name[], TextField tf) {
		int div =  Integer.parseInt(tf.getText());
		
		int[] numbers = new int[15];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
        shuffle(numbers);
        
		String tmp = "\n\n";
		for (int i = 0; i < div; i++) {
			tmp += (i+1) + "조 :                                                                                                          \n";
			for (int j = 0; j < Math.ceil(15.0 / div); j++) {
				if (i*div + j >= 15) {
					break;
				}
				tmp += name[numbers[i*div+j]] + " ";
			}
			tmp += "\n\n";
		}
		result.setText(tmp);
	}
	// 셔플 알고리즘
	public static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }
}
