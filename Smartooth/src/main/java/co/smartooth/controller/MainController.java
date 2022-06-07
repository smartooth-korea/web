package co.smartooth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	
//	 현재 <a>태그 src로 url 호출이 되기 때문에 GET을 사용할 수 밖에 없음
//	@RequestMapping(value = {"/main.do"}, method = {RequestMethod.GET}) 
//	  public String main(HttpServletRequest request, Model model) throws Exception {
//	    AuthVO authVO = (AuthVO)OpHelper.getSession(request, BaseConfig.MGR_SESSION_KEY);
//	    model.addAttribute("domainList", this.mainService.getMyDomainList(authVO));
//		model.addAttribute("title","dashboard");
//		model.addAttribute("categoriesName","대시보드");
//		System.out.println("main.do");
//	    return "/main";
//	  }
	
	@GetMapping("/")
	public String main() {
		return "index";
	}
}
