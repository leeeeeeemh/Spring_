package com.spring.biz.user;

public interface UserService {
	UserVO getUser(String id);
	int insertUser(UserVO vo);
}
