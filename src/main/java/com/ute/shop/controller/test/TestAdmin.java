package com.ute.shop.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test/admin")
public class TestAdmin {
	
	@RequestMapping("") //URL
	public String index() {
		return "admin/index-admin"; //HTML
	}	
	
	@RequestMapping("news/list") //URL
	public String news_list() {
		return "admin/news/list"; //HTML
	}
}
