package com.spring.withwork.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.withwork.vo.MessengerVO;
import com.spring.withwork.vo.NoticeVO;

@Repository("NoticeDAO")
public class NoticeDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public NoticeDAO() {
		System.out.println(">> NoticeDAO 객체생성");
	}
	
	public int insertNotice(NoticeVO vo) {
		System.out.println("---> Mybatis로 insertNotice() 실행");
		return mybatis.insert("NoticeDAO.insertNotice", vo);
	}

	public int updateNotice(NoticeVO vo) {
		System.out.println("---> Mybatis로 updateNotice() 실행");
		return mybatis.update("NoticeDAO.updateNotice", vo);
	}
	
	public void deleteNotice(NoticeVO vo) {
		System.out.println("---> Mybatis로 deleteNotice() 실행");
		mybatis.insert("NoticeDAO.deleteNotice", vo);
	}
	
	public NoticeVO getNotice(NoticeVO vo) {
		System.out.println("---> MyBatis로 getNotice() 실행");
		return mybatis.selectOne("NoticeDAO.getNotice", vo);
	}
	
	public List<NoticeVO> getNoticeList(NoticeVO vo) {
		System.out.println("===> MyBatis로 getNoticeList() 실행");
		
		return mybatis.selectList("NoticeDAO.getNoticeList", vo);
	}
	
	public void insertMessenger(MessengerVO vo) {
		System.out.println("---> Mybatis로 insertMessenger() 실행");
		mybatis.insert("NoticeDAO.insertMessenger", vo);
	}
	
}
