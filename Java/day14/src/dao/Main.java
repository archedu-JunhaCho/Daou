package dao;

public class Main {
	public static void main(String[] args) throws Exception {
		ITEST02DAO dao_maria = new TEST02DAO_MariaDB();
		ITEST02DAO dao_oracle = new TEST02DAO_OracleDB();
		
		TEST02VO_text test = new TEST02VO_text();
		TEST02VO_recomm test2 = new TEST02VO_recomm();

		dao_maria.read_text();
		dao_oracle.read_text();
	}
}
