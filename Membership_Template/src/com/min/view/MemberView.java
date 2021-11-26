package com.min.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.min.controller.MemberController;
import com.min.model.vo.Member;
/**
 * 사용자에게 보여지는 화면. 출력 구문들을 처리.
 * @author minmin
 * @since 1.0
 */
public class MemberView {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private MemberController mc = new MemberController();

	/**
	 * 사용자에게 보여지는 첫 화면
	 * 
	 * @throws IOException
	 */
	public void mainMenu() throws IOException {
		while (true) {
			System.out.println("::::: 회원 관리 :::::");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 아이디 검색");
			System.out.println("4. 회원 이름(키워드) 검색");
			System.out.println("5. 회원 정보 수정");
			System.out.println("6. 회원 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.println("--------------------");
			System.out.print("실행할 작업 번호 : ");
			int menu = Integer.parseInt(br.readLine());
			switch (menu) {
			case 1:
				insertMember();
				break;
			case 2:
				selectAll();
				break;
			case 3:
				searchByUserId();
				break;
			case 4:
				searchByUserName();
				break;
			case 5:
				updateMember();
				break;
			case 6:
				deleteMember();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	// 회원 정보 관리용 화면
	/**
	 * 회원 추가 화면
	 * 
	 * @throws IOException
	 */
	private void insertMember() throws IOException {
		System.out.println("----- 회원 추가 메뉴 -----");
		System.out.print("아이디 : ");
		String userId = br.readLine();
		System.out.print("비밀번호 : ");
		String userPwd = br.readLine();
		System.out.print("이름 : ");
		String userName = br.readLine();
		System.out.print("성별(M/F) : ");
		String gender = String.valueOf(br.readLine().toUpperCase().charAt(0));
		System.out.print("나이 : ");
		int age = Integer.parseInt(br.readLine());
		System.out.print("이메일 : ");
		String email = br.readLine();
		System.out.print("전화번호(숫자) : ");
		String phone = br.readLine();
		System.out.print("주소 : ");
		String address = br.readLine();
		System.out.print("취미(,로 공백없이 나열) : ");
		String hobby = br.readLine();

		mc.inserMember(userId, userPwd, userName, gender, age, email, phone, address, hobby);
	}

	/**
	 * 회원 전체 조회 화면
	 */
	private void selectAll() {
		System.out.println("----- 회원 전체 조회 -----");
		mc.selectAll();
	}

	/**
	 * 회원 아이디로 검색하는 화면
	 * 
	 * @throws IOException
	 */
	private void searchByUserId() throws IOException {
		System.out.println("----- 회원 아이디 검색 ------");
		System.out.print("검색할 아이디를 입력하세요 : ");
		String userId = br.readLine();
		mc.searchByUserId(userId);
	}

	/**
	 * 이름 키워드로 회원 검색하는 화면
	 * 
	 * @throws IOException
	 */
	private void searchByUserName() throws IOException {
		System.out.println("----- 회원 이름 검색(키워드) -----");
		System.out.print("검색할 키워드를 입력하세요 : ");
		String keyword = br.readLine();
		mc.searchByUserName(keyword);
	}

	/**
	 * 회원 정보 수정 화면
	 * 
	 * @throws IOException
	 */
	private void updateMember() throws IOException {
		System.out.println("----- 회원 정보 수정 -----");
		System.out.print("수정할 회원 아이디 : ");
		String userId = br.readLine();
		System.out.print("비밀번호 입력 : ");
		String userPwd = br.readLine();
		System.out.println("_____ 수정할 정보 _____");
		System.out.println("1. 비밀번호");
		System.out.println("2. 이름");
		System.out.println("3. 성별");
		System.out.println("4. 나이");
		System.out.println("5. 이메일");
		System.out.println("6. 전화번호");
		System.out.println("7. 주소");
		System.out.println("8. 취미");
		System.out.println("--------------------");
		System.out.print("수정할 항목을 선택하세요 : ");
		int menu = Integer.parseInt(br.readLine());
		System.out.print("수정할 내용을 입력하세요 : ");
		String change = br.readLine();
		mc.updateMember(userId, userPwd, menu, change);
	}

	/**
	 * 회원 탈퇴 화면
	 */
	private void deleteMember() throws IOException {
		System.out.println("----- 회원 삭제 -----");
		System.out.print("탈퇴할 회원 아이디 : ");
		String userId = br.readLine();
		System.out.print("비밀번호 입력 : ");
		String userPwd = br.readLine();
		mc.deleteMember(userId, userPwd);
	}

	// 화면 출력용 메소드
	/**
	 * 처리 성공 출력 화면
	 * 
	 * @param message 출력할 상태 메세지
	 */
	public void printSuccess(String message) {
		System.out.println("\n처리 완료 : " + message);
	}

	/**
	 * 처리 실패 출력 화면
	 * 
	 * @param message 출력할 상태 메세지
	 */
	public void printFail(String message) {
		System.out.println("\n처리 실패 : " + message);
	}

	/**
	 * 리스트 출력 화면
	 * 
	 * @param list : 출력할 리스트
	 */
	public void printList(ArrayList<Member> list) {
		System.out.println("\n"+list.size()+"명의 정보를 출력합니다.");
		for (Member m : list) {
			System.out.println(m);
		}
	}

	/**
	 * 회원 한명을 출력하는 화면
	 * 
	 * @param m : 출력할 회원
	 */
	public void printOne(Member m) {
		System.out.println("\n"+ m.getUserId() + " 회원의 정보입니다.");
		System.out.println(m);
	}
}
