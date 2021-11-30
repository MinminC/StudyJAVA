package com.kh.controller;

import java.util.ArrayList;

import com.kh.Service.VideoService;
import com.kh.model.vo.Video;
import com.kh.view.VideoView;

public class VideoController {

	public void selectByVideoTitle(String keyword) {		
		ArrayList<Video> list = new VideoService().selectByVideoTitle(keyword);
		
		if(list.isEmpty()) {
			new VideoView().displayNodata();
		}else {		
			new VideoView().displayList(list);
		}
		
	}

	public void deleteVideo(String videoTitle) {
		int result = new VideoService().deleteVideo(videoTitle);
		
		if(result > 0){
			new VideoView().displaySuccess("성공적으로 삭제되었습니다.");
		}else {
			new VideoView().displayFail("삭제가 완료되지 않았습니다.");
		}
		
	}

	public void selectAll() {
		ArrayList<Video> list = new VideoService().selectAll();    
        
        
        if(list.isEmpty()) { 
            new VideoView().displayNodata();            
        }else { 
            new VideoView().displayList(list);
        }
    }

	public void updateVideo(String videoTitle, String videoGenre, String videoRuntime, int stock) {
		
		      Video v = new Video();
		      v.setVideoTitle(videoTitle);
		      v.setVideoGenre(videoGenre);
		      v.setVideoRuntime(videoRuntime);
		      v.setStock(stock);

		      int result = new VideoService().updateVideo(v);
		      if (result > 0) {
		         new VideoView().displaySuccess("비디오 정보 수정 성공");
		      } else {
		         new VideoView().displayFail("비디오 정보 수정 실패");
		      }
		   }
		
	

	public void insertVideo(String videoTitle, String videoGenre, String videoRuntime, int stock) {
		Video v = new Video( videoTitle,  videoGenre,  videoRuntime,  stock);
		
		int result = new VideoService().insertVideo(v);
		
		if(result > 0) {
			new VideoView().displaySuccess("비디오 추가 성공!!");
		}else {
			new VideoView().displayFail("추가 실패 : 요청값이 잘못 되었습니다.");
		}
		
	}

	public void rentVideo(String videoTitle) {
		int result = new VideoService().rentVideo(videoTitle);
		if(result>0) {
			new VideoView().displaySuccess("비디오 대여 성공했습니다.");
		} else if(result<0){
			new VideoView().displayFail("비디오 재고가 없습니다.");
		}else {
			new VideoView().displayFail("해당 비디오는 존재하지 않습니다.");
		} 
		
	}

	public void returnVideo(String videoTitle) {
		int result = new VideoService().returnVideo(videoTitle);
		if(result>0) {
			new VideoView().displaySuccess("비디오 반납 성공했습니다.");
		}else {
			new VideoView().displayFail("해당 비디오는 등록되지 않았습니다.");
		} 
		
	}

	public void rankingVideo() {
		ArrayList<Video> list = new VideoService().rankingVideo();
		
		if(list.isEmpty()) {
			new VideoView().displayNodata();
			
		}else {
			new VideoView().displayRankList(list);
		}		
		
	}	

}
