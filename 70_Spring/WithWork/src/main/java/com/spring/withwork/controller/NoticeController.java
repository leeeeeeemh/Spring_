package com.spring.withwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@RequestMapping("/getNoticeList.do")
	public List<NoticeVO> getNoticeList(NoticeVO vo, Model model) {
		System.out.println(">>> 글 전체 목록 - String getNoticeList()");
		
		List<NoticeVO> notice = noticeService.getNoticeList(vo);
		model.addAttribute("notice", notice);
		System.out.println("getNoticeList() notice : " + notice);
		
		return notice;
	}
	
	@RequestMapping("/insertNotice.do")
	public String insertNotice(NoticeVO vo) {
		System.out.println(">>> 글 입력 - insertNotice()");
		System.out.println("> insertNotice() vo : " + vo);
		noticeService.insertNotice(vo);
		return "notice.jsp";
	}
	
}
