package co.smartooth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class testController {
	
	@Autowired(required = false)

	@RequestMapping(value = {"/test"})
	public String test() {
		return "test";
	}
	
	@RequestMapping(value = {"/register"})
	public String regist() {
		return "register";
	}

	@RequestMapping(value = {"/mailAuth"})
	public String mailAuth() {
		return "mail";
	}
	
	
	@RequestMapping(value = {"/login"})
	public String login() {
		return "login";
	}
	
}
