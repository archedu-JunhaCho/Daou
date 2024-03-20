// DB insert from another file
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TEST075 {
	public static List<TEST01VO> arr;
	public static void main(String[] args) {
		String url = "jdbc:mariadb://localhost:3306/day11";
		String id = "root";
		String pass = "1111";
		
		try {
			// setting driver + connect + statement
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,id,pass);
			Statement stmt = conn.createStatement();
			
			// query
			String sql_insert = "insert into studentt values (20202 , \"조준하\", \"오류동\")";

            select_sql(stmt);
            print_sql();
            
			// end
			stmt.close();
			conn.close();
		}
		catch (Exception e){
			return;
		}
	}
	
	public static void select_sql(Statement stmt) throws SQLException {
		String sql = "select * from studentt";
		ResultSet rs = stmt.executeQuery(sql);
		// get metadata
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        
        arr = new ArrayList<TEST01VO>();
		// copy
		while(rs.next()) {
			TEST01VO vo = new TEST01VO();
			vo.setStId(rs.getString("stId"));
			vo.setName(rs.getString("name"));
			vo.setAddr(rs.getString("addr"));
			arr.add(vo);
		}
	}
	
	public static void print_sql() throws SQLException{
		for (TEST01VO vo : arr) {
			System.out.println(vo.getStId() +" "+ vo.getName() +" "+ vo.getAddr());
		}
	}
}
