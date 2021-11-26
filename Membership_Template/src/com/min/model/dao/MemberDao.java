package com.min.model.dao;

import static com.min.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.min.model.vo.Member;
/**
 * Data Access Object.<p>
 * MemberService의 요청을 DB와 처리하는 클래스
 * @author minmin
 * @since 1.0
 */
public class MemberDao {

	/**
	 * 회원 추가 DAO <p> 요렇게 한줄 띄울수도 있다. p태그! 프론트랑 비슷
	 * @param conn 생성된 Connection
	 * @param m    추가할 회원
	 * @return 추가 성공 시 0보다 큰 값, 실패 시 0
	 */
	public int insertMember(Connection conn, Member m) {
		
		
		int result = 0;
		PreparedStatement pstmt = null;

		
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";

		try {
			
			pstmt = conn.prepareStatement(sql);

			
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());

			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 회원 전체 조회 DAO
	 * 
	 * @param conn 생성된 Connection 객체
	 * @return 조회된 회원 목록
	 */
	public ArrayList<Member> selectAll(Connection conn) {
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER ORDER BY USERNO";

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next())
				list.add(new Member(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPWD"),
						rset.getString("USERNAME"), rset.getString("GENDER"), rset.getInt("AGE"),
						rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("ADDRESS"),
						rset.getString("HOBBY"), rset.getDate("ENROLLDATE")));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	/**
	 * 회원 삭제 DAO
	 * 
	 * @param conn    생성된 Connection 객체
	 * @param userId  삭제할 아이디
	 * @param userPwd 비밀번호
	 * @return 삭제 성공 시 0보다 큰 값, 실패시 0
	 */
	public int deleteMember(Connection conn, String userId, String userPwd) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MEMBER WHERE USERID = ? AND USERPWD = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 회원 아이디 검색 DAO
	 * 
	 * @param conn   생성된 Connection 객체
	 * @param userId 검색할 아이디
	 * @return 검색된 회원정보
	 */
	public Member searchByUserId(Connection conn, String userId) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "SELECT * FROM MEMBER WHERE USERID = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			if (rset.next())
				m = new Member(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPWD"),
						rset.getString("USERNAME"), rset.getString("GENDER"), rset.getInt("AGE"),
						rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("ADDRESS"),
						rset.getString("HOBBY"), rset.getDate("ENROLLDATE"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}

	/**
	 * 회원 이름 키워드로 검색 DAO
	 * 
	 * @param conn    생성된 Connection 객체
	 * @param keyword 검색할 키워드
	 * @return 검색된 회원들의 정보
	 */
	public ArrayList<Member> searchByUserName(Connection conn, String keyword) {
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			rset = pstmt.executeQuery();

			while (rset.next())
				list.add(new Member(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPWD"),
						rset.getString("USERNAME"), rset.getString("GENDER"), rset.getInt("AGE"),
						rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("ADDRESS"),
						rset.getString("HOBBY"), rset.getDate("ENROLLDATE")));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return list;
	}

	/**
	 * 회원 수정 DAO
	 * 
	 * @param conn     생성된 Connection 객체
	 * @param userId   수정할 아이디
	 * @param userPwd  비밀번호
	 * @param menuType 수정할 항목
	 * @param change   수정할 내역
	 * @return
	 */
	public int updateMember(Connection conn, String userId, String userPwd, String menuType, String change) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET " + menuType + " = ? WHERE USERID = ? AND USERPWD = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			if (menuType.equals("AGE"))
				pstmt.setInt(1, Integer.parseInt(change));
			else
				pstmt.setString(1, change);

			pstmt.setString(2, userId);
			pstmt.setString(3, userPwd);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}
