package co.smartooth.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import co.smartooth.service.MailAuthService;
import co.smartooth.service.UserService;
import co.smartooth.utils.AES256Util;
import co.smartooth.vo.MailAuthVO;

@RestController
public class MailAuthController {


	@Autowired(required = false)
	private MailAuthService mailAuthService;

	@Autowired(required = false)
	private UserService userService;
	
	
	/**
	 * 인증 메일 발송
	 **/
	@RequestMapping(value = {"/app/user/signUp/emailAuth.do"} , method = {RequestMethod.POST})
	@ResponseBody
		public HashMap<String,Object> mailAuth(@RequestBody HashMap<String, String> paramMap) {

		HashMap<String,Object> hm = new HashMap<String,Object>();
		int duplicateChkId = 0;

		// Parameter :: userId 값 검증
		String userId = (String)paramMap.get("USER_ID");
		// (Null 체크 및 공백 체크)
		if(userId == null || userId.equals("")) {
			hm.put("code", "401");
			hm.put("msg", "아이디가 누락되어있습니다.");
			return hm;
		}
		
		try {
			// 아이디 중복 체크 :: 0 일 경우, 아이디가 존재 하지 않는 경우, 0이 아닌 경우 아이디가 존재
			duplicateChkId = userService.duplicateChkId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(duplicateChkId == 0) { // 아이디가 존재하지 않는 경우, 메일 발송
			try {
				mailAuthService.sendMail(userId);
				mailAuthService.updateAuthStatusN(userId);
			} catch (Exception e) {
				hm.put("code", "500");
				hm.put("msg", "서버 오류");
				e.printStackTrace();
				return hm;
			}
			hm.put("code", "000");
			hm.put("msg", "메일 발송 완료");
		}else {
			hm.put("code", "402");
			hm.put("msg", "이미 등록 되어있는 이메일입니다");			
		}
		return hm;
	}
	
	
	/**
	 * 인증 메일 URL 클릭시 메일 인증 진행
	 **/
	@RequestMapping(value = {"/app/user/signUp/emailConfirm.do"} , method = {RequestMethod.GET})
	@ResponseBody
	public HashMap<String,Object> signUpConfirm(@RequestParam Map<String, String> paramMap) throws Exception {

		HashMap<String,Object> hm = new HashMap<String,Object>();
		// userId(email), authKey 가 일치할경우 AUTH_STATUS 업데이트
		String userId = paramMap.get("USER_ID");
		String authKey = paramMap.get("AUTH_KEY");
		String decId = "";
		String decAuthKey = "";
		
		
		// 아이디와 인증번호 복호화
		AES256Util aes256Util = new AES256Util();
		decAuthKey = aes256Util.aesDecode(authKey);
		decId = aes256Util.aesDecode(userId);
		
		if(decAuthKey.contains("false")) {
			hm.put("code", "403");
			hm.put("msg", "인증 실패");
			return hm;
		}
		
		// 인증 메일 상태 'Y'로 변경
		mailAuthService.updateAuthStatusY(decId);

		// AUTH_STATUS의 상태를 JSON으로 return
		hm.put("code", "Please Go back to application, and Click 'verification confirmation' button");
		hm.put("msg", "Certification Success");
		return hm;

	}
	
	
	/**
	 * 앱에서 메일 인증 여부 확인
	 **/
	@RequestMapping(value = {"/app/user/signUp/emailAuthChk.do"} , method = {RequestMethod.POST})
	@ResponseBody
	public HashMap<String,Object> emailAuthChk(@RequestBody Map<String, String> paramMap) throws Exception {

		HashMap<String,Object> hm = new HashMap<String,Object>();
		String authStatusYn = "";
		
		String userId = paramMap.get("USER_ID");
		
		if(userId == null || userId.equals("")) {
			hm.put("code", "401");
			hm.put("msg", "아이디 누락");
			return hm;
		}
		
		// 사용자의 메일 인증 여부 확인
		authStatusYn = mailAuthService.isEmailAuthEnabled(userId);
		// Null 체크
		if(authStatusYn != null && !authStatusYn.equals("")) {
			if(authStatusYn.equals("Y")) { // Y일 경우 인증 완료
				hm.put("code", "000");
				hm.put("msg", "인증 성공");
			}else {  // N일 경우 인증 실패
				hm.put("code", "403");
				hm.put("msg", "인증 실패");
			}
		}else {
			hm.put("code", "404");
			hm.put("msg", "인증을 요청한 아이디가 아닙니다");
		}
		return hm;
	}
}
