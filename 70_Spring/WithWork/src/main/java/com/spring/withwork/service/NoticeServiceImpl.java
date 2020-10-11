package com.spring.withwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.withwork.dao.NoticeDAO;
import com.spring.withwork.vo.NoticeVO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	public NoticeServiceImpl() {
		System.out.println(">> NoticeServiceImpl() 객체생성");
	}
	
	@Override
	public int insertNotice(NoticeVO vo) {
		return noticeDAO.insertNotice(vo);
	}

	@Override
	public int insertMessenger(NoticeVO vo) {
		return noticeDAO.insertMessenger(vo);
	}

	@Override
	public int updateNotice(NoticeVO vo) {
		return noticeDAO.updateNotice(vo);
	}

	@Override
	public void deleteNotice(NoticeVO vo) {
		noticeDAO.deleteNotice(vo);
	}

	@Override
	public NoticeVO getNotice(NoticeVO vo) {
		return noticeDAO.getNotice(vo);
	}

	@Override
	public List<NoticeVO> getNoticeList(NoticeVO vo) {
		return noticeDAO.getNoticeList(vo);
	}

	@Override
	public List<NoticeVO> getMessengerList(NoticeVO vo) {
		return noticeDAO.getMessengerList(vo);
	}

	@Override
	public void insertRoom(NoticeVO vo) {
		noticeDAO.insertRoom(vo);
	}
	
	@Override
	public void insertChatJoiner(NoticeVO vo) {
		noticeDAO.insertChatJoiner(vo);
	}

	@Override
	public List<NoticeVO> getChatMember(NoticeVO vo) {
		return noticeDAO.getChatMember(vo);
	}
	
	@Override
	public List<NoticeVO> getChatMember2(NoticeVO vo) {
		return noticeDAO.getChatMember2(vo);
	}

	@Override
	public List<NoticeVO> getNoticeList2(NoticeVO vo) {
		return noticeDAO.getNoticeList2(vo);
	}
	
	@Override
	public List<NoticeVO> getNoticeList_Search(NoticeVO vo) {
		return noticeDAO.getNoticeList_Search(vo);
	}
}
