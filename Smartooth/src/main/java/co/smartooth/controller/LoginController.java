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

import co.smartooth.vo.LoginVO;
import co.smartooth.vo.MailAuthVO;

@Controller
public class LoginController {

//	@Autowired(required = false)
//	private UserService userService;
	
//	@Autowired(required = false)
//	private LoginService loginService;



	@RequestMapping(value = "/")
	public String selectUserInfo() {
		return "login/loginForm";
	}
	
	//	 관리자 웹 로그인
//	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	@RequestMapping(value="/login.do")
    public String loginForm(LoginVO loginVO, @CookieValue(value="REMEMBER", required=false) Cookie rememberCookie) throws Exception {
        
//        if(rememberCookie!=null) {
//            loginVO.setUserId(rememberCookie.getValue());
//            loginVO.setRememberId(true);
//        }
		System.out.println("login.do");
		return "redirect:/main.do";
	}
	
	
	@RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }
	
}
