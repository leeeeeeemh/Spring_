package com.spring.withwork.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
	public void insertMessenger(NoticeVO vo) {
		System.out.println("---> Mybatis로 insertMessenger() 실행");
		mybatis.insert("NoticeDAO.insertMessenger", vo);
	}
	
	public void insertDate(NoticeVO vo) {
		System.out.println("---> Mybatis로 insertDate() 실행");
		mybatis.insert("NoticeDAO.insertDate", vo);
	}
	
	public List<NoticeVO> getChatMember(NoticeVO vo) {
		System.out.println("===> MyBatis로 getChatMember() 실행");
		
		return mybatis.selectList("NoticeDAO.getChatMember", vo);
	}

	public List<NoticeVO> getNoticeList3(NoticeVO vo) {
		System.out.println("===> MyBatis로 getNoticeList3() 실행");
		
		return mybatis.selectList("NoticeDAO.getNoticeList3", vo);
	}
	
}
