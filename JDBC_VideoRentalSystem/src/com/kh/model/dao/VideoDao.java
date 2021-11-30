package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Video;
import static com.kh.common.JDBCTemplate.*;

public class VideoDao {

	public ArrayList<Video> selectByVideoTitle(String keyword, Connection conn) {
		ArrayList<Video> list = new ArrayList<>();
		Video v = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "SELECT * FROM VIDEO WHERE VIDEO_TITLE LIKE '%'|| ? || '%'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				v = new Video();
				v.setVideoNo(rset.getInt("VIDEO_NO"));				
				v.setVideoTitle(rset.getString("VIDEO_TITLE"));
				v.setVideoGenre(rset.getString("VIDEO_GENRE"));
				v.setVideoRuntime(rset.getString("RUNNING_TIME"));
				v.setStock(rset.getInt("STOCK"));
				v.setRentCount(rset.getInt("RENT_COUNT"));
				v.setEnrollDate(rset.getDate("ENROLLDATE"));
				
				list.add(v);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		return list;
	}

	public int deleteVideo(String videoTitle, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM VIDEO WHERE VIDEO_TITLE = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, videoTitle);
			
			result = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	

	public ArrayList<Video> selectAll(Connection conn) {
		ArrayList<Video>list = new ArrayList<>();       
        PreparedStatement pstmt = null; 
        ResultSet rset = null;        
        
        String sql = "SELECT * FROM VIDEO";        
        
        
        try {        
            pstmt = conn.prepareStatement(sql);            
            rset = pstmt.executeQuery();            
            
            while(rset.next()) {              
                Video v = new Video();                   
                v = new Video();
				v.setVideoNo(rset.getInt("VIDEO_NO"));				
				v.setVideoTitle(rset.getString("VIDEO_TITLE"));
				v.setVideoGenre(rset.getString("VIDEO_GENRE"));
				v.setVideoRuntime(rset.getString("RUNNING_TIME"));
				v.setStock(rset.getInt("STOCK"));
				v.setRentCount(rset.getInt("RENT_COUNT"));
				v.setEnrollDate(rset.getDate("ENROLLDATE"));
            
                list.add(v);
            }
            
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rset);
            close(pstmt);            
        }
        
        return list;
	}

	public int updateVideo(Connection conn, Video v) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE VIDEO SET VIDEO_GENRE = ?, RUNNING_TIME = ?, STOCK = ? WHERE VIDEO_TITLE = ?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, v.getVideoGenre());
			pstmt.setString(2, v.getVideoRuntime());
			pstmt.setInt(3, v.getStock());
			pstmt.setString(4, v.getVideoTitle());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertVideo(Connection conn, Video v) {
		int result = 0;		
		PreparedStatement pstmt = null;		
		String sql = "INSERT INTO VIDEO(VIDEO_NO, VIDEO_TITLE, VIDEO_GENRE, RUNNING_TIME, STOCK)" + 
					"VALUES(SEQ_VIDEONO.NEXTVAL, ?, ?, ?, ?)";				
					
		try {
			pstmt = conn.prepareStatement(sql);			
			
			pstmt.setString( 1, v.getVideoTitle() );
			pstmt.setString( 2, v.getVideoGenre() );
			pstmt.setString( 3, v.getVideoRuntime() );
			pstmt.setInt( 4, v.getStock() );
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);			
		}		
		return result;
	}

	@SuppressWarnings("resource")
	public int rentVideo(Connection conn, String videoTitle) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Video v = new Video();

		String searchOneSql = "SELECT * FROM VIDEO WHERE VIDEO_TITLE = ?";
		String sql = "UPDATE VIDEO SET STOCK = ?, RENT_COUNT = ? WHERE VIDEO_TITLE = ?";

		try {
			pstmt = conn.prepareStatement(searchOneSql);
			pstmt.setString(1, videoTitle);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				v.setStock(rset.getInt("STOCK"));
				v.setRentCount(rset.getInt("RENT_COUNT"));
				pstmt = conn.prepareStatement(sql);
				
				if (v.getStock() > 0) {
					pstmt.setInt(1, v.getStock() - 1);
					pstmt.setInt(2, v.getRentCount() + 1);
					pstmt.setString(3, videoTitle);
					result = pstmt.executeUpdate();
				} else {
					result = -1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	@SuppressWarnings("resource")
	public int returnVideo(Connection conn, String videoTitle) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Video v = new Video();

		String searchOneSql = "SELECT * FROM VIDEO WHERE VIDEO_TITLE = ?";
		String sql = "UPDATE VIDEO SET STOCK = ? WHERE VIDEO_TITLE = ?";
		try {
			pstmt = conn.prepareStatement(searchOneSql);
			pstmt.setString(1, videoTitle);
			rset = pstmt.executeQuery();
			pstmt = conn.prepareStatement(sql);
			if (rset.next()) {
				v.setStock(rset.getInt("STOCK"));

				pstmt.setInt(1, v.getStock() + 1);
				pstmt.setString(2, videoTitle);
				
				result = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Video> rankingVideo(Connection conn) {
		ArrayList<Video> list = new ArrayList<>();		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM VIDEO ORDER BY RENT_COUNT DESC";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Video v = new Video();				
				
				v.setVideoNo(rset.getInt("VIDEO_NO"));
				v.setVideoTitle(rset.getString("VIDEO_TITLE"));
				v.setVideoGenre(rset.getString("VIDEO_Genre"));
				v.setVideoRuntime(rset.getString("RUNNING_TIME"));
				v.setStock(rset.getInt("STOCK"));
				v.setRentCount(rset.getInt("RENT_COUNT"));
				v.setEnrollDate(rset.getDate("ENROLLDATE"));
				
				list.add(v);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		
		return list;
	}
}
