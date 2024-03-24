package p01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TEST085 {
public static void main(String[] args) {
	// 입력 파일 경로
    String inputFilePath = "./store_server/mp3/1202.mp3";
    // 출력 파일 경로
    String outputFilePath = "./store_client/test.mp3";

    try {
        // 파일 입력 스트림 생성
        FileInputStream fis = new FileInputStream(inputFilePath);
        // 파일 출력 스트림 생성
        FileOutputStream fos = new FileOutputStream(outputFilePath);

        // 버퍼를 사용하여 데이터 읽기
        byte[] buffer = new byte[8192];
        int bytesRead;
        while (true) {
        	bytesRead = fis.read(buffer);
        	System.out.println(bytesRead);
        	if(bytesRead == -1) {
        		break;
        	}
            // 읽은 데이터를 출력 파일에 쓰기
            fos.write(buffer, 0, bytesRead);
        }
        System.out.println("끝!!!");
        // 스트림 닫기
        fis.close();
        fos.close();

        System.out.println("파일이 성공적으로 복사되었습니다.");
    } catch (IOException e) {
        System.err.println("파일 처리 중 오류가 발생했습니다: " + e.getMessage());
    }
}
}
