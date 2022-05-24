package co.smartooth.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import co.smartooth.service.LoginService;
import co.smartooth.service.UserService;
import co.smartooth.utils.AES256Util;
import co.smartooth.utils.TokenUtil;
import co.smartooth.vo.LoginVO;
import co.smartooth.vo.UserVO;

@RestController
public class LoginController {

	@Autowired(required = false)
	private LoginService loginService;

	@Autowired(required = false)
	private UserService userService;


	@RequestMapping(value = "/")
	public String selectUserInfo() {
		return "login/loginForm";
	}
	
	//	 관리자 웹 로그인
	@RequestMapping(value = {"/login.do"}, method = RequestMethod.POST)
    public String webLogin(LoginVO loginVO, @CookieValue(value="REMEMBER", required=false) Cookie rememberCookie) throws Exception {
        
//      쿠키가 되도록 변경해야함  
//		if(rememberCookie!=null) {
//            loginVO.setUserId(rememberCookie.getValue());
//            loginVO.setRememberId(true);
//        }
		System.out.println("login.do");
		return "redirect:/main.do";
	}
	
	
	@RequestMapping(value = {"/logout"})
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }
	
	
	
	

	
	
	
	
/************************************************************************************************************/	
/**																							 APP																							**/
/************************************************************************************************************/
	
	
	
	
	
	
	/**
	 * 기능   : 앱 로그인 요청
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 5. 16
	 * parameter : HashMap<String,Object>
	 * 					앱에서 JSON형식으로 전달 받은 회원의 ID와 비밀번호를 확인 후 JSON으로 반환
	 * return : HashMap<String,Object>
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = {"/app/login.do"}, method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String,Object> appLogin(@RequestBody HashMap<String, Object> paramMap) {
       
		TokenUtil tokenUtil = new TokenUtil();
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		List<UserVO> data = new ArrayList<UserVO>();
		
		LoginVO loginVO = new LoginVO();
		UserVO userVO = new UserVO();
		
		String userPwd = "";
		String userId = "";
		String userAuthToken = "";
		String loginIp = (String)paramMap.get("LOGIN_IP");
		
		int loginChkByIdPwd = 0;
		int isIdExist = 0;
		
		Date now = new Date();
		
		userId= (String)paramMap.get("USER_ID");
		userAuthToken = tokenUtil.createToken(userId);
		
		// 비밀번호 암호화 
		AES256Util aes256Util = new AES256Util();
		userPwd = aes256Util.aesEncode((String)paramMap.get("USER_PWD"));
		
		if(userPwd.equals("false")) { // 암호화에 실패할 경우
			hm.put("code", "500");
			hm.put("msg", "서버 오류(암호화)");
			return hm;
		}
		
		// 로그인 VO
		loginVO.setUserId(userId);
		loginVO.setUserPwd(userPwd);
		loginVO.setUserAuthToken(userAuthToken);
		loginVO.setLoginDt(now);

		// 회원 VO
		userVO.setUserId(userId);
		userVO.setUserAuthToken(userAuthToken);
		
		try {
			// 로그인 확인
			loginChkByIdPwd = loginService.loginChkByIdPwd(loginVO);
			if(loginChkByIdPwd == 0){ // 0일 경우는 Database에 ID와 비밀번호가 틀린 것
				isIdExist = loginService.isIdExist(loginVO.getUserId());
				if(isIdExist == 0) {
					hm.put("code", "404");
					hm.put("msg", "존재하지 않는 아이디 입니다.");
				}else {
					hm.put("code", "405");
					hm.put("msg", "비밀번호가 틀렸습니다.");
				}
			}else { // 로그인이 정상적으로 완료된 경우 회원의 정보를 제공하고 LOG를 INSERT

				loginService.updateUserAuthToken(loginVO);
				loginService.updateLoginDt(loginVO);
				
				// 로그인 시 회원의 정보를 가져옴 :: List<UserVO>
				data = userService.selectUserInfo(userVO);
				
				// 회원의 정보를 LoginVO에 담고 LOG 테이블 INSERT 파라미터로 전달
				loginVO.setUserNo(data.get(0).getUserNo());
				loginVO.setUserType(data.get(0).getUserType());
				loginVO.setLoginDt(data.get(0).getLoginDt());
				loginVO.setLoginResultCode("000");
				loginVO.setLoginIp(loginIp);
				
				loginService.insertUserLoginHistory(loginVO);
				
				hm.put("data", data);
				hm.put("USER_AUTH_TOKEN", userAuthToken);
				hm.put("USER_NO", data.get(0).getUserNo());
				hm.put("code", "000");
				hm.put("msg", "로그인 성공");
			}
		} catch (Exception e) {
			hm.put("code", "500");
			hm.put("msg", "서버 오류");
			e.printStackTrace();
		}
		return hm;
	}
	
}
