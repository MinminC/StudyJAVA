package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.model.vo.Member;

public class MemberView {
	private Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();

	public void mainMenu() {

		while (true) {
			System.out.println("::::: 회원 관리 프로그램 :::::");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 아이디로 검색");
			System.out.println("4. 회원 이름 키워드로 검색");
			System.out.println("5. 회원 정보 변경");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			System.out.print("이용할 메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch (menu) {
			case 1:
				insertMember();
				break;
			case 2:
				selectAll();
				break;
			case 3:
				selectByUserId();
				break;
			case 4:
				selectByKeyword();
				break;
			case 5:
				updateMember();
				break;
			case 6:
				deleteByUserId();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}

	}

	/**
	 * 회원 추가용 화면
	 */
	public void insertMember() {
		System.out.println("-----회원 추가-----");

		System.out.print("아이디 : ");
		String userId = sc.nextLine();

		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();

		System.out.print("이름 : ");
		String userName = sc.nextLine();

		System.out.print("성별(M/F) : ");
		String gender = sc.nextLine();

		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.print("이메일 : ");
		String email = sc.nextLine();

		System.out.print("전화번호 (숫자만) : ");
		String phone = sc.nextLine();

		System.out.print("주소 : ");
		String address = sc.nextLine();

		System.out.print("취미 (,로 공백없이 나열) : ");
		String hobby = sc.nextLine();

		// 회원 추가 요청 => Controller의 어떤 메소드 호출
		mc.insertMember(userId, userPwd, userName, gender, age, email, phone, address, hobby);

	}
	// -------------------------------------
	// 서비스 요청 처리 후 사용자가 보게 될 응답 화면들

	/**
	 * 회원 전체 조회를 할 수 있는 화면
	 */
	public void selectAll() {
		System.out.println("----- 회원 전체 조회 -----");

		// 회원 전체 조회 요청
		mc.selectAll();

	}

	/**
	 * 사용자에게 검색할 회원의 아이디를 입력받은 후 조회 요청하는 메소드
	 */
	public void selectByUserId() {
		System.out.println("----- 회원 아이디로 검색 -----");
		System.out.print("검색할 아이디 : ");
		String userId = sc.nextLine();
		// 입력한 아이디를 회원 아이디 검색 요청 시 같이 넘김
		mc.selectByUserId(userId);
	}

	/**
	 * 회원 아이디를 키워드로 검색
	 */
	public void selectByKeyword() {
		System.out.println("----- 회원 키워드 검색 -----");
		System.out.print("키워드 입력 : ");
		String keyword = sc.nextLine();

		mc.selectByKeyword(keyword);
	}

	/**
	 * userId를 입력받아 수정할 정보를 입력받고, 회원 정보 수정
	 */
	public void updateMember() {
		System.out.println("----- 회원 정보 수정 -----");
		System.out.print("수정할 아이디 : ");// 수정 가능 범위 : 비밀번호, 이름, 성별, 나이, 이메일, 전화번호, 주소, 취미
		String userId = sc.nextLine();
		System.out.println("_____ 수정할 정보 _____");
		System.out.println("1. 비밀번호");
		System.out.println("2. 이름");
		System.out.println("3. 성별");
		System.out.println("4. 나이");
		System.out.println("5. 이메일");
		System.out.println("6. 전화번호");
		System.out.println("7. 주소");
		System.out.println("8. 취미");
		System.out.print("변경할 정보의 번호를 입력하세요 : ");
		int menu = sc.nextInt();
		sc.nextLine();
		switch (menu) {
		case 1:
			System.out.print("비밀번호 : ");
			break;
		case 2:
			System.out.print("이름 : ");
			break;
		case 3:
			System.out.print("성별(M/F) : ");
			break;
		case 4:
			System.out.print("나이 : ");
			break;
		case 5:
			System.out.print("이메일 : ");
			break;
		case 6:
			System.out.print("전화번호 : ");
			break;
		case 7:
			System.out.print("주소 : ");
			break;
		case 8:
			System.out.print("취미 : ");
			break;
		default:
			System.out.println("없는 번호입니다.");
			return;
		}
		String change = sc.nextLine();
		mc.updateMember(userId, menu, change);
	}

	/**
	 * user아이디로 회원 삭제하기
	 */
	public void deleteByUserId() {

		System.out.println("----- 회원 삭제 -----");
		System.out.print("삭제할 회원 아이디: ");
		String userId = sc.nextLine();

		mc.deleteByUserId(userId);

	}

	/**
	 * 서비스 오청 성공 시 보게될 화면
	 * 
	 * @param message
	 */
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}

	/**
	 * 서비스 요청 실패 시 보게될 화면
	 * 
	 * @param message
	 */
	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
	}

	/**
	 * 조회 서비스 요청 시 조회결과가 없을 때 보게 될 메세지
	 * 
	 * @param message : 사용자에게 보여질 메세지
	 */
	public void displayNodata(String message) {
		System.out.println(message);
	}

	/**
	 * 조회 서비스 요청 시 여러 행이 조회된 결과를 받아서 보게 될 화면
	 * 
	 * @param list : 여러 행이 조회된 결과
	 */
	public void displayList(ArrayList<Member> list) {
		System.out.println("\n조회된 데이터는 " + list.size() + "건입니다.");
//		for(Member m : list) {
//			System.out.println(m);
//		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public void displayOne(Member m) {
		System.out.println("\n조회된 데이터는 다음과 같습니다.");
		System.out.println(m);
	}

}
