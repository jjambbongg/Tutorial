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

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.jjambbongg.springboard.dto.BDto;
import com.jjambbongg.springboard.util.Constant;

public class BDao {

	DataSource  dataSource;
	
	JdbcTemplate template = null;
	
	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		template = Constant.template;
	}
	
	public void reply(String bId, final String bName, final String bTitle, final String bContent, final String bGroup, final String bStep, final String bIndent) {
		replyShape(bGroup, bStep);
		String query = "INSERT INTO mvc_board(bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent) VALUES(?,?,?,?,?,?,?,?)";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				long currentTime = Calendar.getInstance().getTimeInMillis();
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setTimestamp(4, new Timestamp(currentTime));
				ps.setInt(5, 0);
				ps.setInt(6, Integer.parseInt(bGroup));
				ps.setInt(7, Integer.parseInt(bStep));
				ps.setInt(8, Integer.parseInt(bIndent));
			}
		});
	}
	
	public BDto replyView(String bId) {
		String query = "SELECT bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent FROM mvc_board WHERE bId="+bId;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));	
	}
	
	public void delete(final String bId) {
		String query = "DELETE FROM mvc_board WHERE bId="+bId;
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bId));
			}
		});
	}
	
	public void modify(final String bId, final String bName, final String bTitle, final String bContent) {
		String query = "UPDATE mvc_board SET bName=?, bTitle=?, bContent=? WHERE bId=?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bId));
			}
		});	
	}

	public void write(final String bName, final String bTitle, final String bContent) {
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				long currentTime = Calendar.getInstance().getTimeInMillis();
				String query = "INSERT INTO mvc_board(bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent) VALUES(?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				pstmt.setTimestamp(4, new Timestamp(currentTime));
				pstmt.setInt(5, 0);
				pstmt.setInt(6, 0);
				pstmt.setInt(7, 0);
				pstmt.setInt(8, 0);
				return pstmt;
			}
		});
	}
	
	public BDto contentView(String bId) {
		upHit(bId);
		String query = "SELECT bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent FROM mvc_board WHERE bId="+bId;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public ArrayList<BDto> list() {
		String query = "SELECT bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent FROM mvc_board ORDER BY bGroup DESC, bStep ASC";
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}

	private void upHit(final String bId) {
		String query = "UPDATE mvc_board set bHit = bHit + 1 WHERE bId=?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bId));
			}
		});
	}
	
	private void replyShape(final String bGroup, final String bStep) {
		
		String query = "UPDATE mvc_board set bStep = bStep+1 WHERE bGroup = ? and bStep > ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bGroup));
				ps.setInt(2, Integer.parseInt(bStep));
				
			}
		});
	}
}
