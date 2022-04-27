package co.smartooth.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.smartooth.service.UserService;
import co.smartooth.vo.UserVO;

/**
	 RequestMapping 설정 시 
	 앱에서의 요청이 있을 경우 /app/*
	 앱에서 api 요청이 있을 경우 /app/api/* 
	 웹에서의 요청이 있을 경우 /web/*
	 웹에서 api 요청이 있을 경우 /web/api/*
**/

@Controller
public class UserController {
	
	@Autowired(required = false)
	private UserService userService;
	
	
	/**
	 * 기능   : 앱에서의 요청한 유저목록(userList)을 JSON 형식으로 return
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 4. 27
	 * return : HashMap<String,Object>
	 */
	@RequestMapping(value = "/app/api/userList")
	@ResponseBody
	public HashMap<String,Object>  userList() {
		
		List<UserVO> userList = null;
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		try {
			userList = userService.selectUserList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		hm.put("data", userList);
		return hm;

	}

}
