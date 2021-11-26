package com.min.model.service;

import static com.min.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.min.model.dao.MemberDao;
import com.min.model.vo.Member;

/**
 * Service. MemberController에서 값을 받아 MemberDao에 전달해주고 JDBC용 객체의 처리를 완료하는 클래스
 * 
 * @author minmin
 * @since 1.0
 */
public class MemberService {
	
	/**
	 * 회원 추가 서비스
	 * 
	 * @param m 추가할 회원
	 * @return 추가 성공은 0보다 큰 값, 실패하면 0
	 */
	public int insertMember(Member m) {

		Connection conn = getConnection();

		int result = new MemberDao().insertMember(conn, m);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		return result;
	}

	/**
	 * 회원 전체 조회 서비스
	 * 
	 * @return 조회된 리스트
	 */
	public ArrayList<Member> selectAll() {

		Connection conn = getConnection();

		ArrayList<Member> list = new MemberDao().selectAll(conn);
		close(conn);

		return list;
	}

	/**
	 * 회원 삭제 서비스
	 * 
	 * @param userId  삭제할 회원
	 * @param userPwd 비밀번호
	 * @return
	 */
	public int deleteMember(String userId, String userPwd) {
		Connection conn = getConnection();
		int result = new MemberDao().deleteMember(conn, userId, userPwd);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		return result;
	}

	/**
	 * 회원 아이디로 검색 서비스
	 * 
	 * @param userId 검색할 아이디
	 * @return 검색된 회원정보
	 */
	public Member searchByUserId(String userId) {
		Connection conn = getConnection();

		Member m = new MemberDao().searchByUserId(conn, userId);
		close(conn);

		return m;
	}

	/**
	 * 회원 이름 키워드로 찾는 서비스
	 * 
	 * @param keyword 이름 키워드
	 * @return 검색된 회원정보
	 */
	public ArrayList<Member> searchByUserName(String keyword) {
		Connection conn = getConnection();

		ArrayList<Member> list = new MemberDao().searchByUserName(conn, keyword);
		close(conn);

		return list;
	}

	/**
	 * 회원 정보 수정 서비스
	 * 
	 * @param userId   수정할 회원의 아이디
	 * @param userPwd  비밀번호
	 * @param menuType 수정할 항목
	 * @param change   수정할 내역
	 * @return int result 수정 성공 시 0 보다 큰 수, 실패 시 0.
	 */
	public int updateMember(String userId, String userPwd, String menuType, String change) {
		Connection conn = getConnection();

		int result = new MemberDao().updateMember(conn, userId, userPwd, menuType, change);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

}
