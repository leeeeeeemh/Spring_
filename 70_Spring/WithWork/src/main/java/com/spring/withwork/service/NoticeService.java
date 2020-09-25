package com.spring.withwork.service;

import java.util.List;

import com.spring.withwork.vo.NoticeVO;

public interface NoticeService {
	//CRUD 기능 구현 메소드 정의
	int insertNotice(NoticeVO vo);
	void updateNotice(NoticeVO vo);
	void deleteNotice(NoticeVO vo);
	NoticeVO getNotice(NoticeVO vo);
	List<NoticeVO> getNoticeList(NoticeVO vo);
}
