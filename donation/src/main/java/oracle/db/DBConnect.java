package oracle.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnect {
	
	private static Connection conn;
	
	private DBConnect() {}
		public static Connection getConnection() throws Exception{
			if(conn != null) {
				if(!conn.isClosed())
					return conn;
			}
			
			String jdbc = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String uid = "c##systemid";
			String pwd ="systempwd";
			
			try {
				Class.forName(jdbc);
				conn = DriverManager.getConnection(url, uid, pwd);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			return conn;
	}
	private void DBClose() {}
		public static void DBClose(PreparedStatement pstmt, Connection conn) throws Exception {
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
		public static void DBClose(ResultSet rs, PreparedStatement pstmt, Connection conn) throws Exception {
			if(rs != null) {
				try {
					rs.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			DBClose(pstmt, conn);
		}
}