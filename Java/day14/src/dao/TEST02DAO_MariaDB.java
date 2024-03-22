package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TEST02DAO_MariaDB implements ITEST02DAO{
	// DB setting
	String url = "jdbc:mariadb://localhost:3306/kiwoom";
	String id = "root";
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
		String sql = "insert into test_02_t values ( default, now(), ? )";
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, id, pass);
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		// 2.2 DB send
		stmt.setString(1, data);;
		stmt.executeUpdate();
		
		// End
		conn.close();
	}

	@Override
	public void delete(TEST02VO pvo) throws Exception {
		
	}

	@Override
	public void update(TEST02VO pvo) throws Exception {
		
	}

	@Override
	public List<TEST02VO> read(TEST02VO pvo) throws Exception {
		// DB setting
		Class.forName("org.mariadb.jdbc.Driver");
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
		
		// End
		conn.close();
		
		return result;
	}
	
}
