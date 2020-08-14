package com.spring.biz.user.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardRowMapper;
import com.spring.biz.user.UserVO;

@Repository("userDAOSpring")
public class UserDAOSpring extends JdbcDaoSupport {

	//SQL문
	private final String USER_GET
		= "SELECT * FROM USERS WHERE ID = ? ";

	public UserDAOSpring() {
		System.out.println(">> UserDAOSpring() 실행(객체생성)");
	}
	
	@Autowired // 파라미터 타입과 동일한 객체 주입하면서 메소드 실행
	public void setSuperDataSource(DataSource dataSource) {
		System.out.println(">>>> UserDAOSpring.setSuperDataSource() 실행");
		System.out.println("dataSource : " + dataSource);
		super.setDataSource(dataSource);
	}
	
	//글 하나 조회(상세조히)
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring JDBC로 getUser() 실행");
		
		Object[] args = {vo.getId()};
		return super.getJdbcTemplate().queryForObject(USER_GET, 
											args, new UserRowMapper());
	}
	
	
}
