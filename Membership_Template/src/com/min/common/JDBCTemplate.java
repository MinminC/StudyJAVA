package com.min.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 자주 사용하는 기능을 Template화
 * @author minmin
 * @since 1.0
 */
public class JDBCTemplate {

	/**
	 * JDBC용 Connection 객체를 생성하는 메소드
	 * @return 생성된 Connection 객체
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	
	
	/**
	 * JDBC용 Connection 객체를 자원 반납하는 메소드
	 * @param conn 생성된 Connection 객체
	 */
	public static void close(Connection conn) {
		try {
			if (conn != null && conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * JDBC용 Statement 객체를 자원 반납하는 메소드
	 * @param stmt 생성된 Statement 객체
	 */
	public static void close(Statement stmt) {
		try {
			if (stmt != null && stmt.isClosed())
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * JDBC용 Result 객체를 자원 반납하는 메소드
	 * @param rset 생성된 ResultSet 객체
	 */
	public static void close(ResultSet rset) {
		try {
			if (rset != null && rset.isClosed())
				rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 트랜잭션을 COMMIT해주는 메소드
	 * @param conn JDBC용 Connection 객체
	 */
	public static void commit(Connection conn) {
		try {
			if (conn != null && conn.isClosed())
				conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 트랜잭션을 ROLLBACK해주는 메소드
	 * @param conn JDBC용 Connection 객체
	 */
	public static void rollback(Connection conn) {
		try {
			if (conn != null && conn.isClosed())
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
