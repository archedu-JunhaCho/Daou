package dao;

public class Main {
	public static void main(String[] args) throws Exception {
		ITEST02DAO dao_maria = new TEST02DAO_MariaDB();
		ITEST02DAO dao_oracle = new TEST02ADO_OracleDB();
		
		TEST02VO test = new TEST02VO();
		TEST02VO test2 = new TEST02VO();
		
//		dao_maria.add(test);
//		dao_oracle.add(test2);
		dao_oracle.read(test2);
	}
}
