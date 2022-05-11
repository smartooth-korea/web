package co.smartooth.controller;

import java.io.UnsupportedEncodingException;
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
import co.smartooth.vo.UserVO;

@Controller
public class MailAuthController {


	/**
	 *사용자 생성 및 인증번호 생성 후 Database INSERT
	 * */
	@Autowired(required = false)
	private MailAuthService mailAuthService;

	//@RequestMapping("/app/user/signUp/emailAuth")
//	@RequestMapping(value="/app/user/emailAuth", method = {RequestMethod.POST})
	@RequestMapping(value="/app/user/emailAuth", method = {RequestMethod.GET})
	@ResponseBody
	public HashMap<String,Object> mailAuth(@RequestParam Map<String, String> map, ModelAndView mv) {

		HashMap<String,Object> hm = new HashMap<String,Object>();
		String userId = map.get("USER_ID");
		
		// Parameter :: userId 값 검증 (Null 체크 및 공백 체크)
		if(userId == null || userId.equals("")) {
			//하드코딩
			userId = "jungjuhyun12@gmail.com";	
		}
		
		try {
			mailAuthService.sendMail(userId);
		} catch (Exception e) {
			e.printStackTrace();
			hm.put("result", "error");
			return hm;
		}
		hm.put("result", "success");
		return hm;

	}
	
	
	/**
	 *메일 URL 클릭시 메일 인증
	 * */
	@RequestMapping("/app/user/emailConfirm")
	public String signUpConfirm(@RequestParam Map<String, String> map, ModelAndView mv) throws Exception {

		// userId(email), authKey 가 일치할경우 AUTH_STATUS 업데이트
		String userId = map.get("USER_ID");
		String authKey = map.get("AUTH_KEY");
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
		// 현재 관리자 화면으로 화면이 전환되는데 이 부분 어떻게 할지 정해야함
		return "redirect:/";
	}
	

}
