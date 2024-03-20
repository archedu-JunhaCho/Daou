// DB exam
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class TEST074 {
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
			String sql_insert = "insert into studentt values (20202 , \"조준하\", \"오류동\")";
			String sql_update = "update studentt set name = \"조주나\" where name = \"조준하\"";
			String sql_delete = "delete from studentt where name = \"조주나\"";
			//stmt.execute(sql_insert);
			ResultSet rs = stmt.executeQuery(sql);
			// get metadata
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
			// print
			while(rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + ", ");
                }
                System.out.println();
			}
			// end
			stmt.close();
			conn.close();
		}
		catch (Exception e){
			return;
		}
	}
}
