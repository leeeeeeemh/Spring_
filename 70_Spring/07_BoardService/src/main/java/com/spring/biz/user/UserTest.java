package com.spring.biz.user;

import java.util.List;

import com.spring.biz.user.impl.UserDAO;

public class UserTest {

	public static void main(String[] args) {
		UserVO vo = new UserVO();
		vo.setId("test2");
		vo.setPassword("test2");
		vo.setName("여포");
		vo.setRole("user2");
		
		UserDAO dao = new UserDAO();
		
//		dao.insertUser(vo);
//		
//		dao.updateUser(vo);
//		
//		dao.deleteUser(vo);
		
//		UserVO user = dao.getUser(vo);
//		System.out.println("user : " + user);
		
		List<UserVO> user = dao.getUserList();
		System.out.println("user : " + user);
		
	}

}
