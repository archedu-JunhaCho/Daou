package task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Task1 {
	public static void main(String[] args) throws Exception {
		// 1. 파일 불러오기
		BufferedReader in = new BufferedReader(new FileReader("sample.data"));
		
		// 2. DB 연결
		String url = "jdbc:mariadb://localhost:3306/day11";
		String id = "root";
		String pass = "1111";
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, id, pass);
		Statement stmt = conn.createStatement();
		
		// 3. DB 쿼리날리기
		String t = null;
		while ((t = in.readLine()) != null) {
			if (t.indexOf("##") != 0) {
				String arr[] = t.split(",");
				String number = arr[0];
				String data = ",\"" + arr[1] +"\"";
				String sql = "insert into temp_01_t values (" + number + data  + ");";
				stmt.executeUpdate(sql);
			}
		}
		
		// 4. 마무리
		in.close();
		stmt.close();
		conn.close();
	}
}
