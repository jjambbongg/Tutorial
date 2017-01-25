package com.jjambbongg.springboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.jjambbongg.springboard.dto.BDto;

public class BDao {

	DataSource  dataSource;
	
	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent) {
		Connection con = null;
		PreparedStatement pstmt = null;
		long currentTime = Calendar.getInstance().getTimeInMillis();
		int bIdInt = 0;
		if(bId!=null && !bId.isEmpty()) {
			bIdInt = Integer.parseInt(bId);
		}	
		int bGroupInt = 0;
		if(bGroup!=null && !bGroup.isEmpty()) {
			bGroupInt = Integer.parseInt(bGroup);
		}	
		int bStepInt = 0;
		if(bStep!=null && !bStep.isEmpty()) {
			bStepInt = Integer.parseInt(bStep) + 1;
		}
		int bIndentInt = 0;
		if(bIndent!=null && !bIndent.isEmpty()) {
			bIndentInt = Integer.parseInt(bIndent) + 1;
		}
		replyShape(bGroup, bStep);
		
		try {
			String query = "INSERT INTO mvc_board(bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent) VALUES(?,?,?,?,?,?,?,?)";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setTimestamp(4, new Timestamp(currentTime));
			pstmt.setInt(5, 0);
			pstmt.setInt(6, bGroupInt);
			pstmt.setInt(7, bStepInt);
			pstmt.setInt(8, bIndentInt);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public BDto replyView(String bId) {
		BDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int bIdInt = 0;
		if(bId!=null && !bId.isEmpty()) {
			bIdInt = Integer.parseInt(bId);
		}
		
		try {
			String query = "SELECT bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent FROM mvc_board WHERE bId=? ORDER BY bGroup DESC, bStep ASC";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bIdInt);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				dto = new BDto(bIdInt, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;		
	}
	
	public void delete(String bId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int bId_int = 0;
		if(bId!=null && !bId.isEmpty()) {
			bId_int = Integer.parseInt(bId);
		}
		try {
			String query = "DELETE FROM mvc_board WHERE bId=?";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bId_int);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public void modify(String bId, String bName, String bTitle, String bContent) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int bId_int = 0;
		if(bId!=null && !bId.isEmpty()) {
			bId_int = Integer.parseInt(bId);
		}
		try {
			String query = "UPDATE mvc_board SET bName=?, bTitle=?, bContent=? WHERE bId=?";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, bId_int);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public BDto contentView(String bId) {
		BDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int bId_int = 0;
		if(bId!=null && !bId.isEmpty()) {
			bId_int = Integer.parseInt(bId);
		}
		upHit(bId);
		
		try {
			String query = "SELECT bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent FROM mvc_board WHERE bId=? ORDER BY bGroup DESC, bStep ASC";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bId_int);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				dto = new BDto(bId_int, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public void write(String bName, String bTitle, String bContent) {
		Connection con = null;
		PreparedStatement pstmt = null;
		long currentTime = Calendar.getInstance().getTimeInMillis();
		
		try {
			String query = "INSERT INTO mvc_board(bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent) VALUES(?,?,?,?,?,?,?,?)";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setTimestamp(4, new Timestamp(currentTime));
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 0);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<BDto> list() {
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String query = "SELECT bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent FROM mvc_board ORDER BY bGroup DESC, bStep ASC";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}

	private void upHit(String bId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int bId_int = 0;
		if(bId!=null) {
			bId_int = Integer.parseInt(bId);
		}
		try {
			String query = "UPDATE mvc_board set bHit = bHit + 1 WHERE bId=?";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bId_int);
			int updateRst = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	
	
	private void replyShape(String bGroup, String bStep) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int bGroupInt = 0;
		if(bGroup!=null && !bGroup.isEmpty()) {
			bGroupInt = Integer.parseInt(bGroup);
		}	
		int bStepInt = 0;
		if(bStep!=null && !bStep.isEmpty()) {
			bStepInt = Integer.parseInt(bStep);
		}
		try {
			String query = "UPDATE mvc_board set bStep = bStep+1 WHERE bGroup = ? and bStep > ?";
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bGroupInt);
			pstmt.setInt(2, bStepInt);
			int updateRst = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
