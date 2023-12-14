package com.ute.shop.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test/admin-ace")
public class TestAdminAce {
	
	@RequestMapping("") //URL
	public String index() {
		return "admin-ace/index-admin-ace"; //HTML
	}	
	
	@RequestMapping("news/list") //URL
	public String news_single() {
		return "admin-ace/news/list"; //HTML
	}	
	
}
