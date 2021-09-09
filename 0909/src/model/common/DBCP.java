package model.common;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBCP {
	
	public static Connection connect() {
		Connection conn=null;
		try{
			Context initContext=new InitialContext();
			Context envContext=(Context)initContext.lookup("java:/comp/env");
			DataSource ds=(DataSource)envContext.lookup("jdbc/orcl");
			// 프로그래머가 지향하는 "낮은 결합도"★ -> 프로그램이 유연해진다!
			// ★높은 응집도

			conn=ds.getConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn,PreparedStatement pstmt) {
		try{
			pstmt.close();
			conn.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
}
