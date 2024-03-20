package sync;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TEST076 {
	public static void main(String[] args) throws IOException {
		BufferedReader text = new BufferedReader(new FileReader("jamak.smi"));
		BufferedWriter textWriter = new BufferedWriter(new FileWriter("modified_jamak.smi"));
		String result = null;
		
		while ((result = text.readLine()) != null) {
			int index_tmp1 = result.indexOf("SYNC Start=");
			// ΩÃ≈©æ¯¥¬ ∂Û¿Œ
			if (index_tmp1 == -1) {
				textWriter.write(result);
			}
			// ΩÃ≈©¿÷¥¬ ∂Û¿Œ
			else {
				int start = index_tmp1 + 11;
				int end = result.indexOf(">");
				
				String extractedText = result.substring(start, end);
				String modifiedLine = result.replace(extractedText, String.valueOf(Integer.parseInt(extractedText)+100));
				System.out.println("before : " + result);
				System.out.println("after  : " + modifiedLine);
				System.out.println("\n");
				textWriter.write(modifiedLine);
			}
			// ¡ŸπŸ≤ﬁ
			textWriter.newLine();
		}
		
		text.close();
		textWriter.close();
	}
}
