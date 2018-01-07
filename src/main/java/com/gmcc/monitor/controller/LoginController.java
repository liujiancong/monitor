package com.gmcc.monitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("/")
	public String login() {
		return "ftl/login";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "ftl/index";
	}
}
