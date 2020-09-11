package com.spring.exam.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.exam.member.service.MemberService;
import com.spring.exam.member.service.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberSerivce;
	
	@RequestMapping(value = "/signup.do", method = RequestMethod.POST)
	public String signup(MemberVO vo) {
		
		//일부러 예외 발생
		if (vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다 ;;");
		} else if (vo.getName() == null || vo.getName().equals("")) {
			throw new IllegalArgumentException("이름는 반드시 입력해야 합니다 ;;");
		} else if (vo.getPassword() == null || vo.getPassword().equals("")) {
			throw new IllegalArgumentException("비밀번호는 반드시 입력해야 합니다 ;;");
		}
		
		memberSerivce.insertMember(vo);
		
		return "login.jsp";
	}
	
	@RequestMapping(value = "/signup.do", method = RequestMethod.GET)
	public String signupView() {
		return "signup.jsp";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView() {
		return "login.jsp";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(MemberVO vo, Model model) {
		MemberVO loginMember = memberSerivce.checkIdPassword(vo.getId(), vo.getPassword());
		if (loginMember != null) {
			model.addAttribute("loginMember", loginMember);
			return "loginSuccess.jsp";
		} else {
			return "loginFail.jsp";
		}
	}
}
