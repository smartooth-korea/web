package co.smartooth.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.smartooth.vo.LoginVO;

@Controller
public class MainController {
	
	// 현재 <a>태그 src로 url 호출이 되기 때문에 GET을 사용할 수 밖에 없음
	@RequestMapping(value = {"/main.do"}, method = {RequestMethod.GET}) 
	  public String main(HttpServletRequest request, Model model) throws Exception {
//	    LoginVO loginVo = (LoginVO)OpHelper.getSession(request, BaseConfig.MGR_SESSION_KEY);
//	    model.addAttribute("domainList", this.mainService.getMyDomainList(loginVo));
		model.addAttribute("title","dashboard");
		model.addAttribute("categoriesName","대시보드");
		System.out.println("main.do");
	    return "/main";
	  }
}
