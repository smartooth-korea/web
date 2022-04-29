package co.smartooth.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.smartooth.vo.MailAuthVO;

@Controller
public class LoginController {

//	@Autowired(required = false)
//	private UserService userService;
	
//	@Autowired(required = false)
//	private LoginService loginService;



	@RequestMapping(value = "/")
	public String selectUserInfo() {
		return "st/login/loginForm";
	}
	
	///smartooth/app/user/signUp/emailAuth
	// 관리자 웹 로그인
//	@RequestMapping(value={"/" , "/login"}, method=RequestMethod.GET)
//	@RequestMapping(value="/", method=RequestMethod.GET)
//    public ModelAndView loginForm(LoginVO loginVO, @CookieValue(value="REMEMBER", required=false) Cookie rememberCookie) throws Exception {
//        
//		System.out.println("왜 여기 안걸림?");
//		System.out.println("왜 여기 안걸림?");
//		System.out.println("왜 여기 안걸림?");
//		System.out.println("왜 여기 안걸림?");
//        if(rememberCookie!=null) {
//            loginVO.setUserId(rememberCookie.getValue());
//            loginVO.setRememberId(true);
//        }
//        
//        ModelAndView mv = new ModelAndView("st/login/loginForm2");
//        return mv;
//    }
	
	
	@RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }


	
	

//	@RequestMapping(value = "/login.do", method = { RequestMethod.POST })
//	public String login(HttpServletRequest request, Model model, LoginVO loginVo) throws Exception {
//
//		LOGIN_RESULT loginResult = LOGIN_RESULT.OK;

//	    if (Validate.isEmpty(loginVo.getEncMgrId())) {
//	      return alertAndRedirect(model, this.messageSource.getMessage("login.login.001", null, 
//	            LocaleContextHolder.getLocale()), "/login/loginForm.do");
//	    }
//	    if (Validate.isEmpty(loginVo.getEncMgrPwd())) {
//	      return alertAndRedirect(model, this.messageSource.getMessage("login.login.002", null, 
//	            LocaleContextHolder.getLocale()), "/login/loginForm.do");
//	    }
//
//		HttpSession session = request.getSession(true);
//
//		return "redirect:/main/main.do";
//	}
	
	
	
	
	
	
	
}
