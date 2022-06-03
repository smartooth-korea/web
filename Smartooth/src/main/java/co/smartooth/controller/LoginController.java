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

import co.smartooth.service.AuthService;
import co.smartooth.service.LogService;
import co.smartooth.service.UserService;
import co.smartooth.utils.AES256Util;
import co.smartooth.utils.JwtTokenUtil;
import co.smartooth.vo.AuthVO;
import co.smartooth.vo.TeethInfoVO;
import co.smartooth.vo.TeethMeasureVO;
import co.smartooth.vo.UserVO;

@RestController
public class LoginController {

	@Autowired(required = false)
	private AuthService authService;

	@Autowired(required = false)
	private UserService userService;
	
	@Autowired(required = false)
	private LogService logService;
	


	@RequestMapping(value = "/")
	public String selectUserInfo() {
		return "login/loginForm";
	}
	
	//	 관리자 웹 로그인
	@RequestMapping(value = {"/login.do"}, method = RequestMethod.POST)
    public String webLogin(AuthVO authVO, @CookieValue(value="REMEMBER", required=false) Cookie rememberCookie) throws Exception {
        
//      쿠키가 되도록 변경해야함  
//		if(rememberCookie!=null) {
//            authVO.setUserId(rememberCookie.getValue());
//            authVO.setRememberId(true);
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
       
		String userPwd = null;
		String userId = null;
		String loginIp = null;
		String userAuthToken = null;
		
		int loginChkByIdPwd = 0;
		int isIdExist = 0;
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		List<UserVO> userInfo = new ArrayList<UserVO>();
		List<TeethInfoVO> userTeethInfo = new ArrayList<TeethInfoVO>();
		
		AuthVO authVO = new AuthVO();
		UserVO userVO = new UserVO();
		
		
		// 오늘 일자 계산
		Date tmpDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		String sysDate = sdf.format(tmpDate);
		
		// 파라미터 >> 값 setting
		userId= (String)paramMap.get("userId");
		loginIp = (String)paramMap.get("loginIp"); 
		
		// 비밀번호 암호화 
		AES256Util aes256Util = new AES256Util();
		userPwd = aes256Util.aesEncode((String)paramMap.get("userPwd"));
		
		if(userPwd.equals("false")) { // 암호화에 실패할 경우
			hm.put("code", "500");
			hm.put("msg", "Server Error");
			return hm;
		}
		
		// 로그인 VO
		authVO.setUserId(userId);
		authVO.setUserPwd(userPwd);
		authVO.setLoginDt(sysDate);
		// 회원 VO
		userVO.setUserId(userId);
		
		try {
			// 로그인 확인
			loginChkByIdPwd = authService.loginChkByIdPwd(authVO);
			if(loginChkByIdPwd == 0){ // 0일 경우는 Database에 ID와 비밀번호가 틀린 것

				isIdExist = authService.isIdExist(authVO.getUserId());
				if(isIdExist == 0) { // ID가 존재하지 않을 경우
					hm.put("code", "405");
					hm.put("msg", "This ID does not exist.");
				}else { // PWD가 틀렸을 경우
					hm.put("code", "406");
					hm.put("msg", "The password is wrong.");
				}
			}else { // ID와 PWD가 검증된 이후 JWT 토큰과 회원의 정보를 제공하고 LOG를 INSERT

				// JWT TOKEN 발행
				JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
				userAuthToken = jwtTokenUtil.createToken(authVO);
				
				// 로그인 일자 업데이트
				logService.updateLoginDt(authVO);
				
				// 로그인 시 회원의 정보를 가져옴 :: List<UserVO>
				userInfo = userService.selectUserInfo(userVO);
				userTeethInfo = userService.selectUserTeethInfo(userVO);
				
				// 회원의 정보를 authVO에 담고 LOG 테이블 INSERT 파라미터로 전달
				authVO.setUserNo(userInfo.get(0).getUserNo());
				authVO.setUserType(userInfo.get(0).getUserType());
				authVO.setLoginDt(userInfo.get(0).getLoginDt());
				authVO.setLoginResultCode("000");
				authVO.setLoginIp(loginIp);
				
				logService.insertUserLoginHistory(authVO);
				
				hm.put("userInfo", userInfo);
				hm.put("userTeethInfo", userTeethInfo);
				hm.put("userNo", userInfo.get(0).getUserNo());
				hm.put("userAuthToken", userAuthToken);
				hm.put("code", "000");
				hm.put("msg", "Login Success");
			}
		} catch (Exception e) {
			hm.put("code", "500");
			hm.put("msg", "Server Error");
			e.printStackTrace();
		}
		return hm;
	}
	
}
