package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TEST02ADO_OracleDB implements ITEST02DAO {
	// DB setting
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "hr";
	String pass = "1111";
	// input
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	String data = null;
	
	@Override
	public void add(TEST02VO pvo) throws Exception {
		// 1 input
		System.out.print("Please Input Data : ");
		data = in.readLine();
		
		// 2.1 DB connect
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String sql = "insert into test_02_t values ( seq_test_02_no.nextval, sysdate, ? )";
		Connection conn = DriverManager.getConnection(url, id, pass);
		conn.setAutoCommit(false);
		PreparedStatement stmt = conn.prepareStatement(sql);
		try {
			// 2.2 DB send
			stmt.setString(1, data);;
			stmt.executeUpdate();
			
			// End
			conn.commit();
			conn.close();
		}
		catch (Exception e) {
			conn.rollback();
		}
		
	}

	@Override
	public void delete(TEST02VO pvo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	@Override
	public void update(TEST02VO pvo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	@Override
	public List<TEST02VO> read(TEST02VO pvo) throws Exception {
		// DB setting
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String sql = "select * from test_02_t";
		Connection conn = DriverManager.getConnection(url, id, pass);
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		// DB send
		List<TEST02VO> result = new ArrayList<TEST02VO>();
		ResultSet rs = stmt.executeQuery();
		
		// copy
		while(rs.next()) {
			TEST02VO vo = new TEST02VO();
			vo.setNo(Integer.valueOf(rs.getString("no")));
			vo.setThe_time(rs.getString("the_time"));
			vo.setData(rs.getString("data"));
			result.add(vo);
		}
		
		// print
		for (TEST02VO vo : result) {
			System.out.println(vo.toString());
		}
		
		// End
		conn.close();
		
		return result;
	}
	
}
