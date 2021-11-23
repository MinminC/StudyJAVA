package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Member;

/* DAO(Data Access Object)
 * 
 * 데이터베이스 관련된 작업(CRUD)을 전문적으로 담당하는 객체
 * DAO 안에 모든 메서드를 데이터베이스와 관련된 작업으로 마든다
 * 
 * * CRUD - CREATE, REETRIEVE, UPDATE, DELETE,  SQL DML
 *   SELECT
 *   
 *   Controller를 통해서 호출된 기능을 수행
 *   DB에 직접적으로 접근한 후 해당 SQL문을 실행 및 결과 받기(JDBC)
 */
public class MemberDao {

	public int insertMember(Member m) {
		// insert문 => 처리된 행 수 : transaction 처리

		// 필요한 변수들 먼저 세팅
		int result = 0;// 처리된 결과(행 수)를 담아줄 변수
		Connection conn = null;// 접속된 DB의 연결정보를 담는 변수
		Statement stmt = null;// SQL문 실행 후 결과를 받기 위한 변수

		// 실행할 SQL문(완성된 형태로 만들어둘것)
		// INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, 'XXX','XXX',...,SYSDATE)

		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, '" + m.getUserId() + "', '" + m.getUserPwd()
				+ "', '" + m.getUserName() + "', '" + m.getGender() + "', " + m.getAge() + ", '" + m.getEmail() + "', '"
				+ m.getPhone() + "', '" + m.getAddress() + "', '" + m.getHobby() + "', SYSDATE)";
//		System.out.println(sql);
		try {
			// 1)JDBC 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ojdbc6.jar가 누락되었거나, 잘 추가되었지만 오타가 있을 경우 ClassNotFoundException 발생!

			// 2) Connection 객체 생성(DB와 연결 -> url, 계정명, 비번)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");

			// 3) Statement 객체 생성
			stmt = conn.createStatement();

			// 4, 5) DB에 완성된 SQL문을 전달하면서 실행 후 결과(처리된 행 수) 받기
			result = stmt.executeUpdate(sql);

			// 6-2) 트랜잭션 처리
			if (result > 0) {// 성공했을 경우
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
				// 7) 다 쓴 JDBC용 객체 자원 반납 => 생성된 역순으로 close()
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 결과 반환
		return result;// 처리된 행의 수
	}

	public ArrayList<Member> selectAll() {
		// 0) 필요한 변수들 세팅
		// 조회된 결과를 뽑아서 담아줄 변수 => ArrayList 생성(여러 회원의 정보=어려 행)
		ArrayList<Member> list = new ArrayList<>();// 텅빈 리스트 선언
		// Connection, Statement, ResultSet => finally에서 자원 반납을 해주기 위해.
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		// SELECT문이 실행된 조회 결과값들이 처음에 실질적으로 담길 객체

		// 실행할 SQL문 (완성된 형태로)
		String sql = "SELECT * FROM MEMBER ORDER BY USERNO";

		try {
			// 1) JDBC Driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2) Connect 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			// 3) Statement 생성
			stmt = conn.createStatement();
			// 4) SQL문(SELECT)을 전달해서 실행 후, ResultSet 생성
			rset = stmt.executeQuery(sql);
			// 6-1) 현재 조회 결과가 담긴 ResultSet에서 한 행씩 뽑아 VO객체에 담은 후 list 추가
			while (rset.next()) {

				// 현재 rset의 커서가 가리키고 있는 해당 행의 데이터를 하나씩 뽑아서 담아줄 Member객체를 만든다.
				Member m = new Member();
				
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));

				// 리스트에 해당 Member 객체를 담아주기
				list.add(m);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 7) 다 쓴 JDBC 객체 반납(생성의 역순)
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 8) 결과 반환(조회 결과들이 뽑혀서 모두 담겨있는 list)
		return list;
	}

	public Member selectByUserId(String userId) {
		// 0)필요한 변수 세팅
		// 조회된 한 회원에 대한 정보를 담을 변수
		Member m = null;
		// JDBC 관련 객체들 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		// 실행할 SQL문(완성된 형태)
		String sql = "SELECT * FROM MEMBER WHERE USERID = '" + userId + "'";

		try {
			// 1) 드라이버 불러오기

			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2) Connection 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			// 3) Statement 연결
			stmt = conn.createStatement();
			// 4,5) rset
			rset = stmt.executeQuery(sql);
			// 6-1)결과받기
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return m;
	}

	public int deleteByUserId(String userId) {
		// 0) 변수 세팅
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		// 0-1)sql
		String sql = "DELETE FROM MEMBER WHERE USERID = '" + userId + "'";
		System.out.println(sql);
		try {
			// 1) 드라이버 생성
			Class.forName("oracle.jdbc.OracleDriver");
			// 2) Connection 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			// 3) Statement 생성
			stmt = conn.createStatement();
			// 4,5) sql&result에 값
			result = stmt.executeUpdate(sql);

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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public ArrayList<Member> selectByKeyword(String keyword) {
		// 0) 변수 세팅
		ArrayList<Member> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		// 0-1)sql
		String sql = "SELECT * FROM MEMBER WHERE USERID LIKE '%" + keyword + "%'";

		try {
			// 1) Driver 세팅
			Class.forName("oracle.jdbc.OracleDriver");
			// 2) Connection 세팅
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			// 3) Statement 세팅
			stmt = conn.createStatement();
			// 4,5) sql & 값 받기
			rset = stmt.executeQuery(sql);
			System.out.println(sql);
			// 6-1) list에 넣기
			while (rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));

				list.add(m);
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
	 * 
	 * @param userId : 수정할 회원의 아이디
	 * @param menu : 수정할 항목 종류
	 * @param change : 수정할 내용
	 * @return
	 */
	public int updateMember(String userId, int menu, String change) {
		//0) 변수 세팅
		int result = 0;
		Connection conn=null;
		Statement stmt =null;
		String newThing=null;
		
		//0-1)sql
		switch(menu) {
		case 1:newThing="USERPWD = '"+change+"'"; break;
		case 2:newThing="USERNAME = '"+change+"'"; break;
		case 3:newThing="USERGENDER = '"+change+"'"; break;
		case 4:newThing="AGE = "+change; break;
		case 5:newThing="EMAIL = '"+change+"'"; break;
		case 6:newThing="PHONE = '"+change+"'"; break;
		case 7:newThing="ADDRESS = '"+change+"'"; break;
		case 8:newThing="HOBBY = '"+change+"'"; break;
		}
		String sql = "UPDATE MEMBER SET "+newThing+" WHERE USERID='"+userId+"'";
		
		//1) Driver 세팅
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//2) Connection 세팅
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JDBC","JDBC");
			//3) Statement 세팅
			stmt=conn.createStatement();
			//4,5) sql & 결과받기
			result=stmt.executeUpdate(sql);
			//6-2) 트랜젝션 결과 처리
			if(result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
