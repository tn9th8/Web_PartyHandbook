package com.ute.shop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ute.shop.dto.CategoryDTO;
import com.ute.shop.service.ICategoryService;

@Controller
@RequestMapping("admin/category")
public class CategoryControllerAdmin {
	
	@Autowired
	ICategoryService categoryService;
	
	@GetMapping("list") //URL
	public String list(ModelMap model) {
		List<CategoryDTO> categoryDTOs = categoryService.findAll();
		model.addAttribute("cates", categoryDTOs);
		return "admin-ace/category/list"; //HTML
	}
}