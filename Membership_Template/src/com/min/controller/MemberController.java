package com.min.controller;

import java.util.ArrayList;

import com.min.model.service.MemberService;
import com.min.model.vo.Member;
import com.min.view.MemberView;
/**
 * MemberView에서 데이터를 받아 가공하여 MemberService에 넘기는 클래스.
 * @author minmin
 * @since 1.0
 */
public class MemberController {

	/**
	 * 회원 추가 요청
	 * 
	 * @param userId   입력받은 아이디
	 * @param userPwd  입력받은 비밀번호
	 * @param userName 입력받은 이름
	 * @param gender   입력받은 성별
	 * @param age      입력받은 나이
	 * @param email    입력받은 이메일
	 * @param phone    입력받은 전화번호
	 * @param address  입력받은 주소
	 * @param hobby    입력받은 취미들
	 */
	public void inserMember(String userId, String userPwd, String userName, String gender, int age, String email,
			String phone, String address, String hobby) {
		Member m = new Member(userId, userPwd, userName, gender, age, email, phone, address, hobby);
		int result = new MemberService().insertMember(m);
		if (result > 0) {
			new MemberView().printSuccess("회원 가입 성공하셨습니다.");
		} else {
			new MemberView().printFail("가입 실패하셨습니다. 입력한 내용을 확인하세요.");
		}
	}

	/**
	 * 회원 전체 조회 요청
	 */
	public void selectAll() {
		ArrayList<Member> list = new MemberService().selectAll();
		if (list.isEmpty()) {
			new MemberView().printFail("회원이 존재하지 않습니다.");
		} else {
			new MemberView().printList(list);
		}
	}

	/**
	 * 회원 삭제 요청
	 * 
	 * @param userId  삭제할 아이디
	 * @param userPwd 비밀번호
	 */
	public void deleteMember(String userId, String userPwd) {
		int result = new MemberService().deleteMember(userId, userPwd);
		if (result > 0) {
			new MemberView().printSuccess("탈퇴 하셨습니다.");
		} else {
			new MemberView().printFail("아이디, 비밀번호를 확인하세요.");
		}
	}

	/**
	 * 회원 수정 요청
	 * 
	 * @param userId  수정할 아이디
	 * @param userPwd 비밀번호
	 * @param menu    수정할 항목
	 * @param change  수정 내역
	 */
	public void updateMember(String userId, String userPwd, int menu, String change) {
		String menuType = null;
		switch (menu) {
		case 1:
			menuType = "USERPWD";
			break;
		case 2:
			menuType = "USERNAME";
			break;
		case 3:
			menuType = "GENDER";
			change = String.valueOf(change.toUpperCase().charAt(0));
			break;
		case 4:
			menuType = "AGE";
			break;
		case 5:
			menuType = "EMAIL";
			break;
		case 6:
			menuType = "PHONE";
			break;
		case 7:
			menuType = "ADDRESS";
			break;
		case 8:
			menuType = "HOBBY";
			break;
		default:
			System.out.println("잘못된 항목을 선택하셨습니다.");
			return;
		}
		int result = new MemberService().updateMember(userId, userPwd, menuType, change);
		if (result > 0) {
			new MemberView().printSuccess("수정 성공했습니다.");
		} else {
			new MemberView().printFail("수정 실패했습니다. 입력한 내용을 확인하세요.");
		}
	}

	/**
	 * 아이디로 회원 검색 요청
	 * 
	 * @param userId 검색할 아이디
	 */
	public void searchByUserId(String userId) {
		Member m = new MemberService().searchByUserId(userId);
		if (m == null) {
			new MemberView().printFail(userId + " 아이디가 존재하지 않습니다.");
		} else {
			new MemberView().printOne(m);
		}
	}

	/**
	 * 이름 키워드로 검색 요청
	 * 
	 * @param keyword 검색할 이름 키워드
	 */
	public void searchByUserName(String keyword) {
		ArrayList<Member> list = new MemberService().searchByUserName(keyword);
		if (list.isEmpty()) {
			new MemberView().printFail(keyword + "을 가진 이름은 존재하지 않습니다.");
		} else {
			new MemberView().printList(list);
		}
	}
}
