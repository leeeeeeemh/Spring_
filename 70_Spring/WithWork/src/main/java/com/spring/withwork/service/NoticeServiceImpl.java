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
	public void updateNotice(NoticeVO vo) {
		noticeDAO.updateNotice(vo);
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

}
