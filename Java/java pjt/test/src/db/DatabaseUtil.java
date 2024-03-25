package db;

import java.sql.*;

public class DatabaseUtil {
    // settings
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;

    // constructor
    public DatabaseUtil() throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        connect();
        statement();
    }

    // db basic functions
    public void connect() throws Exception {
        String url = "jdbc:mariadb://localhost:3306/java_pjt";
        String id = "root";
        String pass = "1111";
        conn = DriverManager.getConnection(url,id,pass);
    }
    public void statement() throws Exception{
        stmt = conn.createStatement();
    }
    public void close() throws Exception {
        stmt.close();
        conn.close();
    }
    public String cap(String word) {
        return "\"" + word + "\"";
    }
}
