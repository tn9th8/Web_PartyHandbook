package com.ute.shop.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ute.shop.dto.NewsDTO;
import com.ute.shop.service.INewsService;

@Controller
@RequestMapping("news")
public class NewsController {
	
	@Autowired
	INewsService newsService;
	
	@RequestMapping("list") //URL
	public String list(ModelMap model) {
		List<NewsDTO> newsDTOs = newsService.findTop5ByOrderByIdDesc();
		model.addAttribute("newss", newsDTOs);
		return "web/news/list"; //HTML
	}
	
}
