package task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class TestVO {
	Integer number;
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	String data;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}

public class Task2 {
	public static void main(String[] args) throws Exception {
		// 1. 파일 불러오기
		BufferedReader in = new BufferedReader(new FileReader("sample.data"));
		
		// 2. DB 쿼리날리기
		List<TestVO> rl = new ArrayList<TestVO>();
		String t = null;
		while ((t = in.readLine()) != null) {
			if (t.indexOf("##") != 0) {
				TestVO vo = new TestVO();
				vo.setNumber(Integer.parseInt(t.split(",")[0]));
				vo.setData(t.split(",")[1]);
				rl.add(vo);
			}
		}
		restore(rl);
		
		// 5. 마무리
		in.close();
	}
	
	public static void restore(List<TestVO> rl) throws Exception {
		// 3. DB 연결
		String url = "jdbc:mariadb://localhost:3306/day11";
		String id = "root";
		String pass = "1111";
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, id, pass);
		Statement stmt = conn.createStatement();
		
		// 4. 반복 수행
		for (TestVO vo : rl) {
			String sql = "insert into temp_01_t values (";
			sql += String.valueOf(vo.getNumber());
			sql += ",\"" + vo.getData() + "\");";
			stmt.executeUpdate(sql);
		}
		
		conn.close();
		stmt.close();
	}
}
