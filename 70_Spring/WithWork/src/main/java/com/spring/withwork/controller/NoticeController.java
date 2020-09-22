package com.spring.withwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("/getNotice.do")
	public String getNotice(NoticeVO vo, Model model) {
		System.out.println(">>> 글 상세 - String getNotice()");
		
		NoticeVO notice = noticeService.getNotice(vo);
		model.addAttribute("notice", notice);
		System.out.println("getNotice() notice : " + notice);
		
		return "notice.jsp";
	}
	
	@RequestMapping("/insertNotice.do")
	public String insertNotice(NoticeVO vo) {
		System.out.println(">>> 글 입력 - insertNotice()");
		System.out.println("> insertNotice() vo : " + vo);
		
		noticeService.insertNotice(vo);
		return "getNotice.do";
	}
	
}
