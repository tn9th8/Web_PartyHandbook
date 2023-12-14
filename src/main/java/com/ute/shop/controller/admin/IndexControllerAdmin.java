package com.ute.shop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class IndexControllerAdmin {
	
	@RequestMapping("") //URL
	public String index() {
		return "admin-ace/index-admin-ace"; //HTML
	}
}
