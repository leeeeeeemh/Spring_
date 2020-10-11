package com.spring.withwork.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.spring.withwork.service.NoticeService;
import com.spring.withwork.vo.NoticeVO;

@Controller
@SessionAttributes("notice") //notice 라는 이름의 Model이 있으면 Session에 저장
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	public NoticeController() {
		System.out.println("---> NoticeController() 객체생성");
	}
	
	@ResponseBody
	@RequestMapping("/insertNotice.do")
	public int insertNotice(NoticeVO vo) {
		vo.setM_num(6);
		System.out.println(">>> 메세지 입력 - insertNotice()");
		System.out.println("> insertNotice() vo : " + vo);
		
		int notice = noticeService.insertNotice(vo);
		
		System.out.println("insertNotice() notice : " + notice);
		
		return notice;
	}

	@ResponseBody
	@RequestMapping("/insertMessenger.do")
	public int insertMessenger(NoticeVO vo) {
		vo.setM_num(6);
		System.out.println(">>> 메세지 입력 - insertMessenger()");
		System.out.println("> insertMessenger() vo : " + vo);
		
		int notice = noticeService.insertMessenger(vo);
		
		System.out.println("insertMessenger() notice : " + notice);
		
		return notice;
	}
	
	@ResponseBody
	@RequestMapping("/updateNotice.do")
	public int updateNotice(NoticeVO vo) {
		System.out.println(">>> 대화명 수정 - updateNotice()");
		System.out.println("> updateNotice() vo : " + vo);
		
		int notice = noticeService.updateNotice(vo);
		
		System.out.println("updateNotice() notice : " + notice);
		
		return notice;
	}
	
	@ResponseBody
	@RequestMapping("/getNoticeList.do")
	public List<NoticeVO> getNoticeList(NoticeVO vo, Model model) {
		System.out.println(">>> 글 전체 목록 - String getNoticeList()");
		
		List<NoticeVO> notice = noticeService.getNoticeList(vo);
		model.addAttribute("notice", notice);
		
		System.out.println("getNoticeList() notice : " + notice);
		
		return notice;
	}

	@ResponseBody
	@RequestMapping("/getMessengerList.do")
	public List<NoticeVO> getMessengerList(NoticeVO vo, Model model) {
		System.out.println(">>> 글 전체 목록 - String getMessengerList()");
		
		List<NoticeVO> notice = noticeService.getMessengerList(vo);
		model.addAttribute("notice", notice);
		
		System.out.println("getMessengerList() notice : " + notice);
		
		return notice;
	}
	
	@ResponseBody
	@RequestMapping("/getChatMember.do")
	public List<NoticeVO> getChatMember(NoticeVO vo, Model model) {
		System.out.println(">>> 글 전체 목록 - String getChatMember()");
		
		List<NoticeVO> notice = noticeService.getChatMember(vo);
		model.addAttribute("notice", notice);
		
		System.out.println("getChatMember() notice : " + notice);
		
		return notice;
	}
	
	@ResponseBody
	@RequestMapping("/getChatMember2.do")
	public List<NoticeVO> getChatMember2(NoticeVO vo, Model model) {
		System.out.println(">>> 글 전체 목록 - String getChatMember2()");
		
		List<NoticeVO> notice = noticeService.getChatMember2(vo);
		model.addAttribute("notice", notice);
		
		System.out.println("getChatMember2() notice : " + notice);
		
		return notice;
	}
	
	@RequestMapping("/insert11Chat.do")
	public String insertRoom(NoticeVO vo) {
		NoticeVO myMNUM = new NoticeVO();
		myMNUM.setM_num(6);
		System.out.println(">>> 채팅방 생성 - insertRoom()");
		System.out.println("> insertRoom() vo : " + vo);
		
		noticeService.insertRoom(vo);
		noticeService.insertChatJoiner(vo);
		noticeService.insertChatJoiner(myMNUM);
		/* noticeService.getMessengerList(vo); */
		
		return "messenger.jsp";
	}

	
	@ResponseBody
	@RequestMapping("/getNoticeList2.do")
	public List<NoticeVO> getNoticeList2(NoticeVO vo, Model model) {
		System.out.println(">>> 글 전체 목록 - String getNoticeList2()");
		
		List<NoticeVO> notice = noticeService.getNoticeList2(vo);
		model.addAttribute("notice", notice);
		
		System.out.println("getNoticeList2() notice : " + notice);
		
		return notice;
	}
	
	@ResponseBody
	@RequestMapping("/getNoticeList_Search.do")
	public List<NoticeVO> getNoticeList_Search(NoticeVO vo, Model model) {
		System.out.println(">>> 글 전체 목록 - String getNoticeList_Search()");
		
		List<NoticeVO> notice = noticeService.getNoticeList_Search(vo);
		model.addAttribute("notice", notice);
		
		System.out.println("getNoticeList_Search() notice : " + notice);
		
		return notice;
	}
	
}
