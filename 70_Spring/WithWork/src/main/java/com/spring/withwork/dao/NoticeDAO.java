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
	
	public int insertMessenger(NoticeVO vo) {
		System.out.println("---> Mybatis로 insertMessenger() 실행");
		return mybatis.insert("NoticeDAO.insertMessenger", vo);
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
	
	public List<NoticeVO> getMessengerList(NoticeVO vo) {
		System.out.println("===> MyBatis로 getMessengerList() 실행");
		
		return mybatis.selectList("NoticeDAO.getMessengerList", vo);
	}
	
	public void insertRoom(NoticeVO vo) {
		System.out.println("---> Mybatis로 insertRoom() 실행");
		mybatis.insert("NoticeDAO.insertRoom", vo);
	}

	public NoticeVO getInsertRoom(NoticeVO vo) {
		System.out.println("---> Mybatis로 getInsertRoom() 실행");
		return mybatis.selectOne("NoticeDAO.getInsertRoom", vo);
	}
	
	public void insertChatJoiner(NoticeVO vo) {
		System.out.println("---> Mybatis로 insertChatJoiner() 실행");
		mybatis.insert("NoticeDAO.insertChatJoiner", vo);
	}
	
	public List<NoticeVO> getChatMember(NoticeVO vo) {
		System.out.println("===> MyBatis로 getChatMember() 실행");
		
		return mybatis.selectList("NoticeDAO.getChatMember", vo);
	}
	
	public List<NoticeVO> getChatMember2(NoticeVO vo) {
		System.out.println("===> MyBatis로 getChatMember2() 실행");
		
		return mybatis.selectList("NoticeDAO.getChatMember2", vo);
	}

	public List<NoticeVO> setChatMember2(NoticeVO vo) {
		System.out.println("===> MyBatis로 setChatMember2() 실행");
		
		return mybatis.selectList("NoticeDAO.setChatMember2", vo);
	}

	public List<NoticeVO> getChatMember2_In(NoticeVO vo) {
		System.out.println("===> MyBatis로 getChatMember2_In() 실행");
		
		return mybatis.selectList("NoticeDAO.getChatMember2_In", vo);
	}

	public List<NoticeVO> getNoticeList2(NoticeVO vo) {
		System.out.println("===> MyBatis로 getNoticeList2() 실행");
		
		return mybatis.selectList("NoticeDAO.getNoticeList2", vo);
	}

	public List<NoticeVO> getNoticeList_Search(NoticeVO vo) {
		System.out.println("===> MyBatis로 getNoticeList_Search() 실행");
		
		return mybatis.selectList("NoticeDAO.getNoticeList_Search", vo);
	}
	
}
