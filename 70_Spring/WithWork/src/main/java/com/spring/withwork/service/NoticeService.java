package com.spring.withwork.service;

import java.util.List;

import com.spring.withwork.vo.NoticeVO;

public interface NoticeService {
	//CRUD 기능 구현 메소드 정의
	int insertNotice(NoticeVO vo);
	int updateNotice(NoticeVO vo);
	void deleteNotice(NoticeVO vo);
	NoticeVO getNotice(NoticeVO vo);
	List<NoticeVO> getNoticeList(NoticeVO vo);
	void insertMessenger(NoticeVO vo);
	void insertChatJoiner(NoticeVO vo);
	List<NoticeVO> getChatMember(NoticeVO vo);
	List<NoticeVO> getNoticeList2(NoticeVO vo);
	List<NoticeVO> getNoticeList_Search(NoticeVO vo);
}
