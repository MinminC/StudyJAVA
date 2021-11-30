package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.VideoController;
import com.kh.model.vo.Video;

public class VideoView {

	private Scanner sc = new Scanner(System.in);
	private VideoController vc = new VideoController();

	public void mainMenu() {
		while (true) {
			System.out.println("=====추억의 비디오 랭킹=====");
			System.out.println("1. 비디오 전체 확인하기");
			System.out.println("2. 비디오(영화) 추가하기");
			System.out.println("3. 비디오 정보 찾기(키워드)");
			System.out.println("4. 비디오 정보 수정하기 ");
			System.out.println("5. 비디오 삭제하기 ");
			System.out.println("6. 인기비디오 랭킹 리스트");
			System.out.println("7. 비디오 대여하기");
			System.out.println("8. 비디오 반납하기");
			System.out.println("================");
			System.out.println("0.  프로그램 종료");
			System.out.println("-----------------------");
			System.out.print("선택할 메뉴를 입력하세요 : ");

			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				selectAll();
				break;
			case 2:
				insertVideo();
				break;
			case 3:
				selectByVideoTitle();
				break;
			case 4:
				updateVideo();
				break;
			case 5:
				deleteVideo();
				break;
			case 6:
				rankingVideo();
				break;
			case 7:
				rentVideo();
				break;
			case 8:
				returnVideo();
				break;
			case 0:
				System.out.println("오늘도 즐거운 무비라이프~!");
				return;
			default:
				System.out.println("잘못된 값을 입력하셨습니다.");
			}
		}
	}

	private void returnVideo() {
		System.out.println("----- 비디오 반납 -----");
		System.out.print("반납할 비디오 타이틀 : ");
		String videoTitle = sc.nextLine();

		new VideoController().returnVideo(videoTitle);
	}

	private void rentVideo() {
		System.out.println("----- 비디오 대여 -----");
		System.out.print("대여할 비디오 타이틀 : ");
		String videoTitle = sc.nextLine();

		new VideoController().rentVideo(videoTitle);

	}

	private void rankingVideo() {
		System.out.println("===== 대여순위 =====");

		vc.rankingVideo();
	}

	private void deleteVideo() {
		System.out.println("======= 비디오 삭제 =======");
		System.out.print("삭제하실 비디오 제목 : ");
		String videoTitle = sc.nextLine();

		vc.deleteVideo(videoTitle);
	}

	private void updateVideo() {
		System.out.println("----- 비디오 정보 수정 -----");
		System.out.print("수정할 비디오 타이틀 : ");
		String videoTitle = sc.nextLine();
		System.out.println("----------------------");
		System.out.print("수정할 비디오 장르 : ");
		String videoGenre = sc.nextLine();
		System.out.print("수정할 비디오 런타임 : ");
		String videoRuntime = sc.nextInt() + "분";
		System.out.print("수정할 비디오 재고 수량 : ");
		int stock = sc.nextInt();

		new VideoController().updateVideo(videoTitle, videoGenre, videoRuntime, stock);

	}

	private void insertVideo() {
		System.out.println("-----비디오 추가-----");
		System.out.println("해당 내용의 정보를 모두 입력하시오");

		System.out.print("비디오 이름 추가 : ");
		String videoTitle = sc.nextLine();

		String videoGenre = "";
		while (true) {
			System.out.print("장르를 입력해주세요.(드라마, 판타지, 액션, 스릴러, SF중) : ");
			videoGenre = sc.nextLine();
			if (videoGenre.equals("드라마") || videoGenre.equals("판타지") || videoGenre.equals("액션")
					|| videoGenre.equals("스릴러") || videoGenre.equals("SF")) {
				break;
			} else {
				System.out.println("장르명을 확인해주세요");
			}
		}

		System.out.print("영화 상영시간 : ");
		String videoRuntime = sc.nextLine();

		System.out.print("재고 : ");
		int stock = sc.nextInt();

		vc.insertVideo(videoTitle, videoGenre, videoRuntime, stock);

	}

	private void selectAll() {
		System.out.println("-----비디오 전체 조회-----");

		vc.selectAll();

	}

	public void selectByVideoTitle() {
		System.out.println("======= 검색할 비디오 제목 키워드 =======");
		System.out.print("입력하실 키워드 : ");
		String keyword = sc.nextLine();

		vc.selectByVideoTitle(keyword);

	}

	// 사용자에게 데이터조회값에 따라 보여지게 될 화면
	// -------------------------------------------------

	public void displayNodata() {
		System.out.println("조회하신 영화가 없습니다");

	}

	public void displayList(ArrayList<Video> list) {
		System.out.println("조회하신 영화는 '" + list.size() + "'건입니다.");
		for (Video v : list) {
			System.out.println(v);
		}
		System.out.println();
	}

	public void displayRankList(ArrayList<Video> list) {
		int count = 0;
		while (true) {
			System.out.print("출력할 랭킹 : ");
			count = sc.nextInt();
			if (count > list.size()) {
				System.out.println("타이틀 수를 넘었습니다. 다시 입력하세요.");
			} else {
				break;
			}
		}
		System.out.println("====== TOP " + count + " =======");
		for (int i = 0; i < count; i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
	}

	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message+"\n");

	}

	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message+"\n");
	}

}
