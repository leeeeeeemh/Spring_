package com.spring.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;
import com.spring.biz.common.JDBCutil;
import com.spring.biz.user.UserVO;

//@Repository : DB연동작업 처리하는 클래스에 설정 (xxxDAO, xxxDao)
//		- @component 상속받아 기능 확장된 어노테이션
@Repository("userDAO")
public class UserDAO {
	//JDBC 관련 변수(필드)
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	//SQL문
	private final String USER_INSERT
		= "INSERT INTO USERS (ID, PASSWORD, NAME, ROLE) "
		+ "VALUES (?, ?, ?, ?)";
	private final String USER_UPDATE
		= "UPDATE USERS SET ID = ?, PASSWORD = ?, NAME = ?, ROLE = ?";
	private final String USER_DELETE
		= "DELETE FROM USERS WHERE ID = ?";
	private final String USER_GET
		= "SELECT * FROM USERS WHERE ID = ?";
	private final String USER_LIST
		= "SELECT * FROM USERS";
	
	public UserDAO() {
		System.out.println(">> UserDAO() 객체 생성");
	}
	
	//글 입력
	public void insertUser(UserVO vo) {
		System.out.println("===> JDBC로 insertUser() 실행");
		
		conn = JDBCutil.getConnection();
		try {
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());
			
			int result = stmt.executeUpdate();
			System.out.println("result : " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.close(conn, stmt);
		}
		
	}
	
	//글 수정
	public void updateUser(UserVO vo) {
		System.out.println("===> JDBC로 updateUser() 실행");
		
		conn = JDBCutil.getConnection();
		try {
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());
			
			int result = stmt.executeUpdate();
			System.out.println("result : " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.close(conn, stmt);
		}
		
	}
	
	//글 삭제
	public void deleteUser(UserVO vo) {
		System.out.println("===> JDBC로 deleteUser() 실행");
		
		conn = JDBCutil.getConnection();
		try {
			stmt = conn.prepareStatement(USER_DELETE);
			stmt.setString(1, vo.getId());
			
			int result = stmt.executeUpdate();
			System.out.println("result : " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.close(conn, stmt);
		}
		
	}
	
	//글 상세조회(데이터 하나 조회)
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC로 getUser() 실행");
		UserVO user = null;
		
		conn = JDBCutil.getConnection();
		if (conn == null) return null;
		try {
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			
			rs = stmt.executeQuery();
			if (rs.next()) {
				/*
				 user = new UserVO(); 
				 user.setId(rs.getString("ID"));
				 user.setPassword(rs.getString("PASSWORD"));
				 user.setName(rs.getString("NAME")); 
				 user.setRole(rs.getString("ROLE"));
				 */
				
				user = new UserVO(
						rs.getString("ID"),
						rs.getString("PASSWORD"),
						rs.getString("NAME"),
						rs.getString("ROLE"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.close(conn, stmt, rs);
		}
		
		return user;
	}
	
	//글 전체 조회
	public List<UserVO> getUserList() {
		System.out.println("===> JDBC로 getUser() 실행");
		List<UserVO> list = new ArrayList<UserVO>();
		
		conn = JDBCutil.getConnection();
		if (conn == null) return null;
		try {
			stmt = conn.prepareStatement(USER_LIST);
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new UserVO(
						rs.getString("ID"),
						rs.getString("PASSWORD"),
						rs.getString("NAME"),
						rs.getString("ROLE")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	
	
}
