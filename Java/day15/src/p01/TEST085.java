package p01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TEST085 {
public static void main(String[] args) {
	// �Է� ���� ���
    String inputFilePath = "./store_server/mp3/1202.mp3";
    // ��� ���� ���
    String outputFilePath = "./store_client/test.mp3";

    try {
        // ���� �Է� ��Ʈ�� ����
        FileInputStream fis = new FileInputStream(inputFilePath);
        // ���� ��� ��Ʈ�� ����
        FileOutputStream fos = new FileOutputStream(outputFilePath);

        // ���۸� ����Ͽ� ������ �б�
        byte[] buffer = new byte[8192];
        int bytesRead;
        while (true) {
        	bytesRead = fis.read(buffer);
        	System.out.println(bytesRead);
        	if(bytesRead == -1) {
        		break;
        	}
            // ���� �����͸� ��� ���Ͽ� ����
            fos.write(buffer, 0, bytesRead);
        }
        System.out.println("��!!!");
        // ��Ʈ�� �ݱ�
        fis.close();
        fos.close();

        System.out.println("������ ���������� ����Ǿ����ϴ�.");
    } catch (IOException e) {
        System.err.println("���� ó�� �� ������ �߻��߽��ϴ�: " + e.getMessage());
    }
}
}
