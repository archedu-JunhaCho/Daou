// DB Connect
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TEST073 {
	public static void main(String[] args) {
		String url = "jdbc:mariadb://localhost:3306/day11";
		String id = "root";
		String pass = "1111";
		
		try {
			// driver
			Class.forName("org.mariadb.jdbc.Driver");
			// connection
			Connection conn = DriverManager.getConnection(url,id,pass);
			// statement
			Statement stmt = conn.createStatement();
			// query
			String sql = "select * from studentt";
			
			// end
			stmt.close();
			conn.close();
		}
		catch (Exception e){
			return;
		}
	}
}
