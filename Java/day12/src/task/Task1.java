package task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Task1 {
	public static void main(String[] args) throws Exception {
		// 1. ���� �ҷ�����
		BufferedReader in = new BufferedReader(new FileReader("sample.data"));
		
		// 2. DB ����
		String url = "jdbc:mariadb://localhost:3306/day11";
		String id = "root";
		String pass = "1111";
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, id, pass);
		Statement stmt = conn.createStatement();
		
		// 3. DB ����������
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
		
		// 4. ������
		in.close();
		stmt.close();
		conn.close();
	}
}
