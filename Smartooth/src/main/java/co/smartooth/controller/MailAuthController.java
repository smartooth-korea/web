package co.smartooth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.smartooth.service.MailSendService;
import co.smartooth.service.impl.MailSendServiceImpl;
import co.smartooth.vo.UserVO;

@Controller
public class MailAuthController {

//	@Autowired(required = false)
//	UserService userService;

	// 메일 인증
	@Autowired(required = false)
	private MailSendService mailSendService;

//	@RequestMapping("/smartooth/app/user/signUp")
//	public void signUp(@ModelAttribute UserVo userVo) throws Exception {
	// DB에 기본정보 insert :: 회원가입 양식
//		userService.signUp(userVo);

	// 임의의 authKey 생성 & 이메일 발송
//		String authKey = mailSendService.sendAuthMail(userVo.getEmail());
//		userVo.setAuthKey(authKey);

//		Map<String, String> map = new HashMap<String, String>();
//		map.put("email", userVo.getEmail());
//		map.put("authKey", userVo.getAuthKey());
//		System.out.println(map);
//
	// DB에 authKey 업데이트
//		userService.updateAuthKey(map);
//	}

//	@RequestMapping(value = "/smartooth/app/user/signUp/emailAuth", method = RequestMethod.POST)
	@RequestMapping("/app/user/signUp/emailAuth")
	public ModelAndView mailAuth(@RequestParam Map<String, String> map, ModelAndView mv) throws Exception {
//	public void mailAuth(HttpServletRequest request , ModelAndView mv) {

//		String email = map.get("email");
//		String email = request.getParameter("email");
		String email = "jungjuhyun12@gmail.com";
		MailSendService ms = new MailSendServiceImpl();

		ms.mailSend(email);
		mv.setViewName("/view/index");
		return mv;

	}

	@GetMapping("/app/user/signUpConfirm")
	public ModelAndView signUpConfirm(@RequestParam Map<String, String> map, ModelAndView mv) throws Exception {

		// email, authKey 가 일치할경우 authStatus 업데이트
		String email = map.get("email");
//		userService.updateAuthStatus(map);

		mv.addObject("display", "/view/member/signUp_confirm.jsp");
		mv.setViewName("/view/index");
		return mv;
	}

}
