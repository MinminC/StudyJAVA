package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Member;

public class MemberDao {
	/**
	 * 회원 추가하는 DAO  
	 * @param m : 추가할 회원
	 * @return : 성공시 1, 실패시 0
	 */
	public int insertMember(Member m) {
		// 0) 변수, sql
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
//		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, '" + m.getUserId() + "', '" + m.getUserPwd()
//				+ "', '" + m.getUserName() + "', '" + m.getGender() + "', " + m.getAge() + ", '" + m.getEmail() + "', '"
//				+ m.getPhone() + "', '" + m.getAddress() + "', '" + m.getHobby() + "', SYSDATE)";
		// 필요한 변수 : 실행할 SQL (미완성된 형태로)
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";

		try {
			// 1)Driver, conn, pstmt
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			pstmt = conn.prepareStatement(sql);

			// 1-1) 미완성 sql 완성
			// pstmt.setXXXX(?의 위치, 실제값)
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());

			// preparedStatement의 단점=>완성된 SQL문을 볼 수 없다.

			// DB에 완성된 SQL문을 실행 후 결과 받기
			result = pstmt.executeUpdate();

			// 2) 트랜잭션
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 회원 전체 조회하는 DAO	
	 * @return 회원 전체 리스트
	 */
	public ArrayList<Member> selectAll() {
		// 0) 변수, sql
		ArrayList<Member> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = "SELECT * FROM MEMBER ORDER BY USERNO";

		try {
			// 1) Driver, conn, stmt, rset
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			// 2) 리스트에 담기
			while (rset.next()) {
				list.add(new Member(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPWD"),
						rset.getString("USERNAME"), rset.getString("GENDER"), rset.getInt("AGE"),
						rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("ADDRESS"),
						rset.getString("HOBBY"), rset.getDate("ENROLLDATE")));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
	
	/**
	 * 회원 삭제하는 DAO
	 * @param userId 삭제할 회원의 아이디
	 * @param userPwd 비밀번호 확인
	 * @return
	 */
	public int deleteMember(String userId, String userPwd) {
		// 변수, sql
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MEMBER WHERE USERID=? AND USERPWD=?";

		try {
			// driver, conn
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");

			// pstmt
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);

			result = pstmt.executeUpdate();

			// 트랜잭션
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * 회원 수장하는 DAO
	 * @param userId 수정할 회원의 아이디
	 * @param userPwd 비밀번호
	 * @param menuType 수정할 항목
	 * @param change 수정 내역
	 * @return
	 */
	public int updateMember(String userId, String userPwd, String menuType, String change) {
		// 변수, sql
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET " + menuType + " = ? WHERE USERID = ? AND USERPWD = ?";
		System.out.println(userId + userPwd + menuType + change);
		try {
			// DRIVER, conn
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");

			System.out.println(userId + userPwd + menuType + change);

			// pstmt
			pstmt = conn.prepareStatement(sql);
			if (menuType.equals("AGE")) {
				pstmt.setInt(1, Integer.parseInt(change));
			} else {
				pstmt.setString(1, change);
			}
			pstmt.setString(2, userId);
			pstmt.setString(3, userPwd);

			result = pstmt.executeUpdate();

			// 트랜잭션
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * 아이디로 회원 검색하는 DAO
	 * @param userId 검색할 아이디
	 * @return
	 */
	public Member searchByUserId(String userId) {
		// 변수, sql
		Member m = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "SELECT * FROM MEMBER WHERE USERID = ?";

		try {
			// driver, conn
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");

			//pstmt 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				m = new Member(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPWD"),
						rset.getString("USERNAME"), rset.getString("GENDER"), rset.getInt("AGE"),
						rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("ADDRESS"),
						rset.getString("HOBBY"), rset.getDate("ENROLLDATE"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}

	/**
	 * 키워드로 이름 검색하는 DAO
	 * @param keyword 검색할 이름 키워드
	 * @return
	 */
	public ArrayList<Member> searchByUserName(String keyword) {
		//변수, sql
		ArrayList<Member> list=new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE ?";

		try {
			// driver, conn
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");

			//pstmt 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");

			rset = pstmt.executeQuery();

			//리스트에 담기
			while (rset.next()) {
				list.add(new Member(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPWD"),
						rset.getString("USERNAME"), rset.getString("GENDER"), rset.getInt("AGE"),
						rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("ADDRESS"),
						rset.getString("HOBBY"), rset.getDate("ENROLLDATE")));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
