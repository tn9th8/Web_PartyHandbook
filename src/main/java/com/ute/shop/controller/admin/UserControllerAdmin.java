package com.ute.shop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class UserControllerAdmin {
	
	@GetMapping("login")
	public String login() {
		return "admin-ace/user/login";
	}
	
}
