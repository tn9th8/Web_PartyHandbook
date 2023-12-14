package com.ute.shop.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ute.shop.dto.NewsDTO;
import com.ute.shop.service.INewsService;
import com.ute.shop.service.StorageService;

@Controller
@RequestMapping("news")
public class NewsController {
	
	@Autowired
	INewsService newsService;
	
	@Autowired 
	private StorageService storageService;
	
	@GetMapping("list") //URL
	public String list(ModelMap model) {
		List<NewsDTO> newsDTOs = newsService.findTop5ByOrderByIdDesc();
		model.addAttribute("newss", newsDTOs);
		return "web/news/list"; //HTML
	}
	
	@GetMapping("single/{id}")
	public String detailSingle(ModelMap model, @PathVariable("id") Long id) {
		NewsDTO newsDTO = newsService.findById(id); //productService.findById(productId);
		model.addAttribute("news", newsDTO);
		return "web/news/single";
	}
	
	@GetMapping("images/{fileName:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String fileName){
		Resource file = storageService.loadAsResource(fileName);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
	
}
