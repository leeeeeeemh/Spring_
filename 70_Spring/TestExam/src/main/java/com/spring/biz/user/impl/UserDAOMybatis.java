package com.spring.biz.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.biz.user.UserVO;

@Repository("userDAOMybatis")
public class UserDAOMybatis {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public UserDAOMybatis() {
		System.out.println(">> UserDAOMybatis() 실행(객체생성)");
	}

	//회원등록
	public int insertUser(UserVO vo) {
		System.out.println("===> MyBatis로 insertUser() 실행");
		int result = mybatis.insert("UserDAO.insertUser", vo);
		return result;
	}
	
	// 회원 조회
	public UserVO getUser(String id) {
		System.out.println("===> MyBatis로 getUser() 실행");
		return mybatis.selectOne("UserDAO.getUser", id);
	}
	
}