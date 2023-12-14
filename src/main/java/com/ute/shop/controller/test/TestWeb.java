package com.ute.shop.controller.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ute.shop.dto.NewsDTO;
import com.ute.shop.service.INewsService;

@Controller
@RequestMapping("test")
public class TestWeb {
	
	@RequestMapping("") //URL
	public String index() {
		return "web/index-web"; //HTML
	}	
	
//	@RequestMapping("news/list") //URL
//	public String news_list() {
//		return "web/news/list"; //HTML
//	}
	@Autowired
	INewsService newsService;
	@RequestMapping("news/list") //URL
	public String list(ModelMap model) {
		List<NewsDTO> newsDTOs = newsService.findTop5ByOrderByIdDesc();
		model.addAttribute("newss", newsDTOs);
		return "web/news/list"; //HTML
	}
	
	@RequestMapping("news/single") //URL
	public String news_single() {
		return "web/news/single"; //HTML
	}

}
