package tw.brad.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class MemberDB {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://localhost/iii";
	private static final String QUERY_SQL = "SELECT * FROM member";
	private static final String INSERT_SQL = 
		"INSERT INTO member (account,passwd,realname) VALUES (?,?,?)";
	private Connection conn;
	private ResultSet rs;
	
	public MemberDB() throws Exception {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL, prop);
	}
	
	public int addNew(String account, String passwd, String realname) throws Exception{
		PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL);
		pstmt.setString(1, account);
		pstmt.setString(2, BCrypt.hashpw(passwd, BCrypt.gensalt()));
		pstmt.setString(3, realname);
		return pstmt.executeUpdate();
	}
	
}
