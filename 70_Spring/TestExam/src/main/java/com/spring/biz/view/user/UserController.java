package com.spring.biz.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.user.UserService;
import com.spring.biz.user.UserVO;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	public UserController() {
		System.out.println("--->> UserController() 객체생성");
	}
	
	// 요청방식 POST에 대한 처리
	@RequestMapping(value="/signup.do", method=RequestMethod.POST)
	public String signup(UserVO vo, Model model) {
		System.out.println(">>> 회원가입 처리 - signup()");
		
		//일부러 예외 발생
		if (vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다 ;;");
		} else if (vo.getName() == null || vo.getName().equals("")) {
			throw new IllegalArgumentException("이름는 반드시 입력해야 합니다 ;;");
		} else if (vo.getPassword() == null || vo.getPassword().equals("")) {
			throw new IllegalArgumentException("비밀번호는 반드시 입력해야 합니다 ;;");
		}		
		
		int result = userService.insertUser(vo);
		System.out.println("result :" + result);
		
		if (result < 1) {
			throw new IllegalArgumentException("회원가입에 실패하였습니다");
			
		} else {
			UserVO singUser = userService.getUser(vo.getId());
			model.addAttribute("model", singUser);
			
			return "success.jsp";
		}
		
	}
	
	/* @ModelAttribute : 모델의 속성값으로 저장(속성명 별도지정)
	 *   별도 명칭 부여 안하면 <데이터타입>의 첫글자 소문자로 작성된 명칭사용
	 * @ModelAttribute UserVO --> 속성명 userVO 형태
	 * @ModelAttribute("user") UserVO ---> 속성명 user 사용
	 * **********************************/
	@RequestMapping(value="/signup.do", method=RequestMethod.GET)
	public String signupView(@ModelAttribute("user") UserVO vo) {
		System.out.println(">>> 회원가입 처리 - signupView()");

		return "signup.jsp";
	}

}
