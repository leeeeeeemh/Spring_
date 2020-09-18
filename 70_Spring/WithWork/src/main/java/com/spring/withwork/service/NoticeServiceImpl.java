package com.spring.withwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.withwork.dao.NoticeDAO;
import com.spring.withwork.vo.NoticeVO;

@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDAO NoticeDao;
	
	@Override
	public void insertNotice(NoticeVO notice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNotice(NoticeVO notice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNotice(NoticeVO notice) {
		// TODO Auto-generated method stub
		
	}

}
