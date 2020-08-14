package com.spring.biz.user;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

public class UserServiceClient {

	public static void main(String[] args) {
		//1. 스프링 컨테이너 구동
		AbstractApplicationContext container 
				= new GenericXmlApplicationContext("applicationContext_after_returning.xml");
		System.out.println("--- 컨테이너 구동 후 ---");
		
		//2. 스프링 컨테이너 사용
		UserService userService = (UserService) container.getBean("userService");
		
		//2-1. 입력
//		UserVO vo = new UserVO();
//		vo.setId("test3");
//		vo.setPassword("test3");
//		vo.setName("유비");
//		vo.setRole("user3");
//		
//		userService.insertUser(vo);
		
		//전체목록 조회
		List<UserVO> list = userService.getUserList();
		for (UserVO user : list) {
			System.out.println(user);
		}
		
		//3. 스프링 컨테이너 종료
		container.close();
	}

}
