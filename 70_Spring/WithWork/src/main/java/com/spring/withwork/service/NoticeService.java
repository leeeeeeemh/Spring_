package com.spring.withwork.service;

import com.spring.withwork.vo.NoticeVO;

public interface NoticeService {
	
	void insertNotice(NoticeVO notice);
	void updateNotice(NoticeVO notice);
	void deleteNotice(NoticeVO notice);
}
