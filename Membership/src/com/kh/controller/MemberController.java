package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;
import com.kh.view.MemberView;

public class MemberController {
	/**
	 * 사용자의 회원 추가 요청을 처리해주는 메소드
	 * 
	 * @param userId
	 * @param userPwd
	 * @param userName
	 * @param gender
	 * @param age
	 * @param email
	 * @param phone
	 * @param address
	 * @param hobby    => 사용자가 요청 시 입력했던 값들
	 */
	public void insertMember(String userId, String userPwd, String userName, String gender, int age, String email,
			String phone, String address, String hobby) {

		// 전달된 데이터들을 Member객체에 담기
		Member m = new Member(userId, userPwd, userName, gender, age, email, phone, address, hobby);

		int result = new MemberDao().insertMember(m);

		if (result > 0) {// 성공했을 경우
			new MemberView().displaySuccess("회원 추가 성공");// 이렇게 생성하는 건 처리를 해당 메소드만 받아와서 메모리 부하 줄여서 그런가?
		} else {// 실패했을 경우
			new MemberView().displayFail("회원 추가 실패");
		}
	}

	/**
	 * 사용자의 회원 전체 조회 요청을 처리해주는 메소드
	 */
	public void selectAll() {
		// 결과값을 담을 변수
		// SELECT -> ResultSet -> ArrayList<Member>

//		ArrayList<Member> list = new ArrayList<>();
//		list = new MemberDao().selectAll();

		ArrayList<Member> list = new MemberDao().selectAll();

		// 조회 결과가 있는지 없는지 판단 후 사용자가 보게 될 View 화면 지정
		if (list.isEmpty()) {// 요소가 없음 => 조회결과가 없음
			new MemberView().displayNodata("전체 조회 결과가 없습니다.");
		} else {// 요소가 존재함 => 조회결과가 있음.
			new MemberView().displayList(list);
		}
	}

	/**
	 * 사용자의 아이디로 검색요청을 처리해주는 메소드
	 * 
	 * @param userId : 사용자가 검색하고자 하는 아이디
	 * @return
	 */
	public Member selectByUserId(String userId) {// SELECT문 -> ResultSet(1행)
		// 0) 변수 지정
		Member m = new MemberDao().selectByUserId(userId);

		// 조회 결과가 있는지 없는지 판단 후 사용자가 보게될 View 지정
		if (m == null) {// 조회 결과가 없는 경우
			new MemberView().displayNodata(userId + "에 대한 검색 결과가 없습니다.");
		} else {// 조회 결과가 있는 경우
			new MemberView().displayOne(m);
		}
		return m;
	}

	public void deleteByUserId(String userId) {
		int result = new MemberDao().deleteByUserId(userId);

		if (result > 0) {// 삭제한 결과가 있는 경우
			new MemberView().displaySuccess("회원 삭제 성공");
		} else {// 삭제 실패할 경우
			new MemberView().displayFail("회원 삭제 실패");
		}
	}

	public ArrayList<Member> selectByKeyword(String keyword) {
		ArrayList<Member> list = new MemberDao().selectByKeyword(keyword);
		if(list.isEmpty()) {
			new MemberView().displayNodata(keyword+"의 조회 결과가 없습니다.");
		}else {
			new MemberView().displayList(list);
		}
		return list;
	}

	public void updateMember(String userId, int menu, String change) {
		int result = new MemberDao().updateMember(userId, menu, change);
		
		if(result > 0) {//회원 정보 수정할 경우
			new MemberView().displaySuccess("정보 수정 성공");
		}else {//수정 실패할 경우
			new MemberView().displayFail("정보 수정 실패");
		}
	}
}
