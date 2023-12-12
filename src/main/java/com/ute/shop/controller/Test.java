package com.ute.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
	@RequestMapping("") //URL
	public String list() {
		return "admin/users/list_users"; //HTML
	}

}
