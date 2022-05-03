package co.smartooth.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.smartooth.vo.LoginVO;

@Controller
public class MainController {
	
	@RequestMapping(value = {"/st/main.do"}, method = {RequestMethod.GET})
	  public String main(HttpServletRequest request, Model model) throws Exception {
//	    LoginVO loginVo = (LoginVO)OpHelper.getSession(request, BaseConfig.MGR_SESSION_KEY);
//	    model.addAttribute("domainList", this.mainService.getMyDomainList(loginVo));
		model.addAttribute("title","dashboard");
		System.out.println("main.do");
	    return "/st/main";
	  }
	
}
