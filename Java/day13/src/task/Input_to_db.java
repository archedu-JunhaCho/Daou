// How insert input text to DB?
package task;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Input_to_db {
	public static void main(String[] args) throws Exception {
		// 1.1 setting for input
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String data = null;
		String number = null;
		
		// 1.2 input
		System.out.print("Please Input number : ");
		number = in.readLine();
		System.out.print("Please Input Data : ");
		data = in.readLine();
		
		// 2.1 DB connect
		String url = "jdbc:mariadb://localhost:3306/day11";
		String id = "root";
		String pass = "1111";
		String sql = "insert into temp_01_t values ( ?, ? )";
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, id, pass);
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		// 2.2 DB send
		stmt.setInt(1, Integer.valueOf(number));
		stmt.setString(2, data);;
		stmt.executeUpdate();
		
		// End
		conn.close();
		System.exit(0);
	}
}
