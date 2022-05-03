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

import co.smartooth.service.MailAuthService;
import co.smartooth.service.impl.MailAuthServiceImpl;
import co.smartooth.utils.CryptoUtil;
import co.smartooth.vo.MailAuthVO;

@Controller
public class MailAuthController {

//	@Autowired(required = false)
//	UserService userService;

	// 메일 인증
	@Autowired(required = false)
	private MailAuthService mailAuthService;

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
		// 하드코딩
		String toEmail = "smartooth.system@gmail.com";
		mailAuthService.sendMail(toEmail);
		mv.setViewName("/view/index");
		return mv;

	}

	@RequestMapping("/app/user/signUp/emailConfirm")
	public String signUpConfirm(@RequestParam Map<String, String> map, ModelAndView mv) throws Exception {

		// userId(emai)l, authKey 가 일치할경우 AUTH_STATUS 업데이트
		String userId = map.get("userId");
		String authKey = map.get("authKey");
		String decAuthKey = "";
		
		CryptoUtil cryptoUtil = new CryptoUtil();
		decAuthKey = cryptoUtil.decrypt(authKey);
		
		MailAuthVO mailAuthVO = new MailAuthVO();
		mailAuthVO.setUserId(userId);
		mailAuthVO.setAuthKey(decAuthKey);
		
		// 사용자 존재 여부 확인 (유효성 검사)
		if(mailAuthService.isValidation(mailAuthVO)) {
			// Datebase에 인증 상태를 업데이트
			mailAuthService.updateAuthStatus(userId);
		}
		// AUTH_STATUS의 상태를 변경한 후 로그인 화면으로 redirect
		return "redirect:/";
	}

}
