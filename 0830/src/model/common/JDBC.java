package model.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC {
	
	public static Connection getConnection() {
		Connection conn=null;
		
		String jdbc_driver="oracle.jdbc.driver.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName(jdbc_driver);
			conn=DriverManager.getConnection(jdbc_url,"kim","1234");
		} catch(Exception e){
			System.out.println(e);
		}
		return conn;
	}
	
	public static void close(Connection conn,PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		} catch(Exception e){
			System.out.println(e);
		}
	}
	
}
