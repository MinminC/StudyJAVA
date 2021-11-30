package com.kh.Service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.kh.common.JDBCTemplate.*;
import com.kh.model.dao.VideoDao;
import com.kh.model.vo.Video;

public class VideoService {

	public ArrayList<Video> selectByVideoTitle(String keyword) {
		Connection conn = getConnection();
		ArrayList<Video> list = new VideoDao().selectByVideoTitle(keyword, conn);
		
		close(conn);
		
		return list;
	}

	public int deleteVideo(String videoTitle) {
		Connection conn = getConnection();
		int result = new VideoDao().deleteVideo(videoTitle, conn);
		
		//트랜잭션 처리
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}	
		
		//자원반납
		close(conn);				
		return result;
	}

	public ArrayList<Video> selectAll() {
		Connection conn = getConnection();
		ArrayList<Video> list = new VideoDao().selectAll(conn);
		
		close(conn);
		
		return list;
	}

	public int updateVideo(Video v) {
		Connection conn = getConnection();
		int result = new VideoDao().updateVideo(conn, v);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int insertVideo(Video v) {
		Connection conn = getConnection();
		
		int result = new VideoDao().insertVideo(conn, v);
		
		if(result > 0) {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int rentVideo(String videoTitle) {
		Connection conn = getConnection();
		int result = new VideoDao().rentVideo(conn, videoTitle);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public int returnVideo(String videoTitle) {
		Connection conn = getConnection();
		int result = new VideoDao().returnVideo(conn, videoTitle);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public ArrayList<Video> rankingVideo() {
		Connection conn = getConnection();
		
		ArrayList<Video>list = new VideoDao().rankingVideo(conn);
		
		close(conn);
		
		return list;
	}

}
